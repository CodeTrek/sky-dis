package com.sky.dis.scene;

import gov.nasa.worldwind.layers.IconLayer;
import gov.nasa.worldwind.render.DrawContext;
import gov.nasa.worldwind.render.UserFacingIcon;

import java.awt.Dimension;
import java.net.URL;
import java.util.HashMap;
import java.util.Vector;

import com.sky.dis.Activator;

public class ForceIdLayer extends IconLayer {

    private static class Symbol {

        boolean deletable;
        UserFacingIcon icon;
        String id;

        Symbol(IActor actor) {
            URL imageSource = Activator.getDefault().getBundle().getEntry("/symbols/friend_ring.png");
            icon = new UserFacingIcon(imageSource, actor.getPosition());
            icon.setAlwaysOnTop(true);
            icon.setVisible(true);
            icon.setSize(new Dimension(32, 32));
            deletable = false;
            id = actor.getId();
        }

        void update(IActor actor) {
            icon.setPosition(actor.getPosition());
        }
    }

    private HashMap<String, Symbol> symbols;

    public ForceIdLayer() {
        super();

        setName("Force ID");

        setAlwaysUseAbsoluteElevation(true);
        setViewClippingEnabled(true);
        setHorizonClippingEnabled(false);
        setRegionCulling(false);
        setEnabled(false);
        
        symbols = new HashMap<String, Symbol>();
    }

    @Override
    public void preRender(DrawContext dc) {

        for (Symbol symbol : symbols.values()) {
            symbol.deletable = true;
        }

        super.preRender(dc);
    }

    @Override
    public void render(DrawContext dc) {
        addSymbols();
        updateSymbols();
        deleteSymbols();

        super.render(dc);
    }

    private void addSymbols() {
        for (IActor actor : Scene.getInstance().getActors()) {

            if (symbols.get(actor.getId()) == null) {
                Symbol symbol = new Symbol(actor);
                symbols.put(actor.getId(), symbol);
                addIcon(symbol.icon);
            }
        }
    }

    private void deleteSymbols() {
        Vector<Symbol> garbage = new Vector<Symbol>();

        // Collect the garbage.
        for (Symbol symbol : symbols.values()) {
            if (symbol.deletable) {
                garbage.add(symbol);
            }
        }

        // Take out the garbage.
        for (Symbol symbol : garbage) {
            symbols.remove(symbol.id);
            removeIcon(symbol.icon);
        }
    }

    private void updateSymbols() {
        for (IActor actor : Scene.getInstance().getActors()) {
            Symbol symbol = symbols.get(actor.getId());
            symbol.deletable = false;
            symbol.update(actor);
        }
    }
}

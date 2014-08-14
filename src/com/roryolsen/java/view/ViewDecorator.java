package com.roryolsen.java.view;

/**
 * Created by roryolsen on 8/13/14.
 */
public abstract class ViewDecorator extends View {

    private final View decoratedView;

    public ViewDecorator(View decoratedView) {
        this.decoratedView = decoratedView;
    }

    public View getDecoratedView() {
        return decoratedView;
    };
}

package com.reflex_game.utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.AbstractBorder;

/** Swing controls that paint and clip themselves to rounded rectangles. */
public final class RoundedComponents {

	private static final int ARC = 14;

	private RoundedComponents() { }

	private static Shape shape(Component component) {
		return new RoundRectangle2D.Float(0, 0,
				component.getWidth() - 1, component.getHeight() - 1, ARC, ARC);
	}

	private static void prepare(Graphics2D graphics) {
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
	}

	public static class Label extends JLabel {
		private static final long serialVersionUID = 1L;

		@Override
		protected void paintComponent(Graphics graphics) {
			Graphics2D copy = (Graphics2D) graphics.create();
			prepare(copy);
			copy.clip(shape(this));
			super.paintComponent(copy);
			copy.dispose();
		}
	}

	public static class Button extends JButton {
		private static final long serialVersionUID = 1L;

		public Button(String text) {
			super(text);
			setBorder(new RoundedBorder());
		}

		@Override
		protected void paintComponent(Graphics graphics) {
			Graphics2D copy = (Graphics2D) graphics.create();
			prepare(copy);
			copy.clip(shape(this));
			super.paintComponent(copy);
			copy.dispose();
		}
	}

	public static class ComboBox<E> extends JComboBox<E> {
		private static final long serialVersionUID = 1L;

		public ComboBox(E[] values) {
			super(values);
			setBorder(new RoundedBorder());
		}

		@Override
		protected void paintComponent(Graphics graphics) {
			Graphics2D copy = (Graphics2D) graphics.create();
			prepare(copy);
			copy.clip(shape(this));
			super.paintComponent(copy);
			copy.dispose();
		}
	}

	public static class TextArea extends JTextArea {
		private static final long serialVersionUID = 1L;

		public TextArea() {
			this("");
		}

		public TextArea(String text) {
			super(text);
			setBorder(new RoundedBorder());
		}

		@Override
		protected void paintComponent(Graphics graphics) {
			Graphics2D copy = (Graphics2D) graphics.create();
			prepare(copy);
			copy.clip(shape(this));
			super.paintComponent(copy);
			copy.dispose();
		}
	}

	private static class RoundedBorder extends AbstractBorder {
		private static final long serialVersionUID = 1L;

		@Override
		public void paintBorder(Component component, Graphics graphics,
				int x, int y, int width, int height) {
			Graphics2D copy = (Graphics2D) graphics.create();
			prepare(copy);
			copy.setColor(new Color(120, 120, 120));
			copy.setStroke(new BasicStroke(1f));
			copy.drawRoundRect(x, y, width - 1, height - 1, ARC, ARC);
			copy.dispose();
		}

		@Override
		public Insets getBorderInsets(Component component) {
			return new Insets(3, 7, 3, 7);
		}
	}
}

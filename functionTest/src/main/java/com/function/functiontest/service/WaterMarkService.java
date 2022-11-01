package com.function.functiontest.service;

import java.awt.*;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class WaterMarkService {

	// sourceImageFile = 원본
	// watermarkImageFile = 삽입할 워터마크
	// destImageFile = 결과

	public void addImageWatermark(File watermarkImageFile, File sourceImageFile, File destImageFile) {

	}

	public void watermarkText(String path, String watermarkText) throws Exception{
		File sourceImageFile = new File(path);
		BufferedImage original = ImageIO.read(sourceImageFile);

		Graphics2D g2d = original.createGraphics();
		g2d.scale(1, 1);
		g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));

		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		Font font = new Font("궁서체", Font.PLAIN, 150);
		GlyphVector fontGV = font.createGlyphVector(g2d.getFontRenderContext(), watermarkText);

		Rectangle size = fontGV.getPixelBounds(g2d.getFontRenderContext(), 0, 0);
		Shape textShape = fontGV.getOutline();

		double textWidth = size.getWidth();
		double textHeight = size.getHeight();

		AffineTransform rotate45 = AffineTransform.getRotateInstance(Math.PI / 4d);
		Shape rotated = rotate45.createTransformedShape(textShape);

		
	}
}

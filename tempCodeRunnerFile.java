// Draw touchlines
	// brush.drawLine(width / 10, 0, width / 10, height);
	// brush.drawLine(width - width / 10, 0, width - width / 10, height);

	// // Draw center line
	// brush.drawLine(fieldWidth / 2, 0, fieldWidth / 2, height);

	// // Draw penalty areas
	// int penaltyAreaWidth = fieldWidth * 2 / 3;
	// int penaltyAreaHeight = goalLineY2 - goalLineY1;
	// brush.drawRect(width / 10, goalLineY1, penaltyAreaWidth, penaltyAreaHeight);
	// brush.drawRect(width - width / 10 - penaltyAreaWidth, goalLineY1, penaltyAreaWidth, penaltyAreaHeight);

	// // Draw goal lines
	// brush.drawLine(0, goalLineY1, width, goalLineY1);
	// brush.drawLine(0, goalLineY2, width, goalLineY2);

	// // Draw penalty spots (12 yards from goal line)
	// int penaltySpotX = width / 10 + penaltyAreaWidth / 6;
	// int penaltySpotY = goalLineY1 + penaltyAreaHeight / 2;
	// brush.fillOval(penaltySpotX - 3, penaltySpotY - 3, 6, 6); // Adjust size as needed

	// brush.fillOval(width - penaltySpotX - 3, penaltySpotY - 3, 6, 6); // Adjust size as needed

	// // Draw center circle
	// int centerX = fieldWidth / 2;
	// int centerY = (goalLineY1 + goalLineY2) / 2;
	// int radius = Math.min(fieldWidth / 5, fieldHeight / 5); // Adjust radius based on field size
	// brush.drawOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
package net.kurobako.gesturefx;

import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;

/**
 * A set of operations that can be used to alternate the transformation of a {@link GesturePane}
 */
public interface GesturePaneOps {
	/**
	 * Centre the target within the viewport to a point, the actual effect is dependent on
	 * {@link GesturePane#getFitMode()}
	 *
	 * @param pointOnTarget a point on the target using the target's coordinate system
	 */
	void centreOn(Point2D pointOnTarget);
	/**
	 * Translates the target by some amount, the actual effect is dependent on
	 * {@link GesturePane#getFitMode()}
	 * <p>
	 * NOTE: X is {@link Dimension2D#getWidth()} and Y is {@link Dimension2D#getHeight()}
	 *
	 * @param targetAmount the amount to translate using the target's coordinate system
	 */
	void translateBy(Dimension2D targetAmount);
	/**
	 * Zooms the target to some scale, the actual effect is bounded by
	 * {@link GesturePane#getMinScale()}, {@link GesturePane#getMaxScale()}, and dependent on
	 * {@link GesturePane#getFitMode()}
	 *
	 * @param scale the scale, invalid values will be clamped by various properties of
	 * {@link GesturePane}
	 * @param pivotOnTarget a pivot point on the target using the target's coordinate system
	 */
	void zoomTo(double scale, Point2D pivotOnTarget);
	/**
	 * Changes the scale of the target by some amount, this is equivalent to calling
	 * {@link #zoomTo(double, Point2D)} with {@link GesturePane#getCurrentScale()} plus the amount
	 *
	 * @param amount the amount, invalid values will be clamped by various properties of
	 * {@link GesturePane}
	 * @param pivotOnTarget a pivot point on the target using the target's coordinate system
	 */
	void zoomBy(double amount, Point2D pivotOnTarget);

}

package easy;

/**Find the total area covered by two rectilinear rectangles in a 2D plane.
 * <p>
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 *                      Y
 *                      ^
 *                      |
 *                      |
 *                      |
 *                      |
 *                      |     (C,D):(3,4)
 *            +------------------+
 *            |         |        |
 *            |         |        |
 *            |         |        |               (G,H):(9,2)
 *            |         +----------------------------+
 *            |         |        |                   |
 *            |         |        |                   |
 *            |         |        |                   |
 *            +---------|--------+-------------------|---------> X
 *      (A,B):(-3,0)    |                            |
 *                      +----------------------------+
 *                  (E,F):(0,-1)
 * https://leetcode.com/static/images/problemset/rectangle_area.png
 * First rectangle: A, B is the bottom left corner, C, D is the top right corner.
 * Second rectangle: E, F is the bottom left corner, G, H is the top right corner.
 * <p>
 * Rectangle Area
 * Assume that the total area is never beyond the maximum possible value of int.
 * <p>
 * Tags: Math
 * Created by Jeffrey on 2016/11/23.
 */
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaA = (C - A) * (D - B);
        int areaB = (G - E) * (H - F);
        int left = Math.max(E, A);
        int right = Math.min(C, G);
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);
        int overlap = 0;
        if(right > left && top > bottom) {
            overlap = (right - left) * (top - bottom);
        }
        return areaA + areaB - overlap;
    }
}

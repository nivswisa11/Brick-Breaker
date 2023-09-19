// 208189126 Niv Swisa

import java.util.List;

/**
 * this class creates lines and calculates intersections points, middle,start and end points.
 *
 * @author Niv Swisa
 */
public class Line {
    private double x1;
    private double x2;
    private double y1;
    private double y2;

    /**
     * line constructor.
     *
     * @param start point value made of x and y
     * @param end   point value made of x and y
     */
    public Line(Point start, Point end) {
        this.x1 = start.getX();
        this.y1 = start.getY();
        this.x2 = end.getX();
        this.y2 = end.getY();
    }

    /**
     * line constructor.
     *
     * @param x1 private double
     * @param y1 private double
     * @param x2 private double
     * @param y2 private double
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    /**
     * calculates the length of the line.
     *
     * @return Return the length of the line
     */
    public double length() {
        return Math.sqrt(((this.x1 - this.x2) * (this.x1 - this.x2)) + ((this.y1 - this.y2) * (this.y1 - this.y2)));
    }

    /**
     * calculates the middle part of the line.
     *
     * @return Returns the middle point of the line
     */
    public Point middle() {
        return new Point(((this.x1 + this.x2) / 2), ((this.y1 + this.y2) / 2));
    }

    /**
     * calculates where the line starts.
     *
     * @return Returns the start point of the line
     */
    public Point start() {
        if (this.x1 > this.x2) {
            return new Point(this.x2, this.y2);
        } else if (this.x2 > this.x1) {
            return new Point(this.x1, this.y1);
        }
        if (this.y1 > this.y2) {
            return new Point(this.x1, this.y1);
        }
        return new Point(this.x2, this.y2);
    }

    /**
     * calculates where the line ends.
     *
     * @return Returns the end point of the line
     */
    public Point end() {
        if (this.x1 < this.x2) {
            return new Point(this.x2, this.y2);
        } else if (this.x2 < this.x1) {
            return new Point(this.x1, this.y1);
        }
        if (this.y1 < this.y2) {
            return new Point(this.x1, this.y1);
        }
        return new Point(this.x2, this.y2);
    }

    /**
     * subtracts double values for higher accuracy.
     *
     * @param a x or y value of a point
     * @param b x or y value of a point
     * @return true if the a and b are the same, false otherwise.
     */
    public static boolean doubleEquals(double a, double b) {
        return Math.abs(a - b) < 0.00001;
    }

    /**
     * calculates the highest y value between two lines.
     *
     * @param other line
     * @return double value of the highest y number.
     */
    public double highestY(Line other) {
        double maxThis, maxOther;
        //find the max y in this line
        maxThis = Math.max(this.y1, this.y2);
        //find the max y in other line
        maxOther = Math.max(other.y1, other.y2);
        return Math.max(maxThis, maxOther);
    }

    /**
     * calculates the lowest y value between two lines.
     *
     * @param other line
     * @return double value of the lowest y number
     */
    public double lowestY(Line other) {
        double minThis, minOther;
        //find the min y in this line
        minThis = Math.min(this.y1, this.y2);
        //find the min y in other line
        minOther = Math.min(other.y1, other.y2);
        return Math.min(minThis, minOther);
    }

    /**
     * calculates the smallest x value between two lines.
     *
     * @param other line
     * @return double value of the smallest x number
     */
    public double smallestX(Line other) {
        double minThis, minOther;
        //find the min x in this line
        minThis = Math.min(this.x1, this.x2);
        //find the min x in other line
        minOther = Math.min(other.x1, other.x2);
        return Math.min(minThis, minOther);
    }

    /**
     * calculates the biggest x value between two lines.
     *
     * @param other line
     * @return double value of the biggest x number
     */
    public double biggestX(Line other) {
        double maxThis, maxOther;
        //max x value of this
        maxThis = Math.max(this.x1, this.x2);
        //max x value of other
        maxOther = Math.max(other.x1, other.x2);
        return Math.max(maxThis, maxOther);
    }

    /**
     * checks if the lines intersect.
     *
     * @param other line
     * @return Returns true if the lines intersect, false otherwise
     */
    public boolean isIntersecting(Line other) {
        double m1, m2, n1, n2, x, y;
        //calculate slope of this
        m1 = ((this.y2 - this.y1) / (this.x2 - this.x1));
        //calculate slope of other
        m2 = ((other.y2 - other.y1) / (other.x2 - other.x1));
        //calculate the n value in the straight line equation
        n1 = this.y1 - (m1 * this.x1);
        //calculate the n value in the straight line equation
        n2 = other.y2 - (m2 * other.x2);
        //calculates the x value of the intersection point
        x = ((n2 - n1) / (m1 - m2));
        //calculates the y value of the intersection point
        y = (m1 * x + n1);
        //if x is in range with the x values of this line and other line
        if ((x <= this.x1 && x >= this.x2) && (x <= other.x1 && x >= other.x2)) {
            return true;
            //if x is in range with the x values of this line and other line
        } else if ((x <= this.x2 && x >= this.x1) && (x <= other.x2 && x >= other.x1)) {
            return true;
            //if x is in range with the x values of this line and other line
        } else if ((x <= this.x1 && x >= this.x2) && (x <= other.x2 && x >= other.x1)) {
            return true;
            //if x is in range with the x values of this line and other line
        } else if ((x <= this.x2 && x >= this.x1) && (x <= other.x1 && x >= other.x2)) {
            return true;
            //if the lines are the same
        } else if (this.equals(other)) {
            return true;
            //if the slopes are equal but the lines never meet
        } else if (m1 == m2 && (this.biggestX(this) < other.smallestX(other)
                || this.smallestX(this) > other.biggestX(other))) {
            return false;
            //if the lines meet at the tip and are parallel to the y-axis
        } else if ((this.lowestY(this) == other.highestY(other) || this.highestY(this)
                == other.lowestY(other)) && doubleEquals(this.x1, other.x1) && doubleEquals(this.x2, other.x2)) {
            return true;
            //if the slopes are equal and the lines overlap
        } else if (doubleEquals(m1, m2) && (this.length() + other.length() > this.highestY(other) - this.lowestY(
                other))) {
            return true;
            //if the lines are parallel to the x-axis and the lines overlap
        } else if ((m1 == 0 && m2 == 0) && (this.length() + other.length() > this.biggestX(other) - this.smallestX(
                other))) {
            return true;
            //if the slopes are equal and the lines overlap
        } else if (doubleEquals(m1, m2) && (((this.smallestX(this) > other.smallestX(other))
                && (this.smallestX(this) < other.biggestX(other))) || ((other.smallestX(other) > this.smallestX(
                        this)) && (other.smallestX(other) < this.biggestX(this))))) {
            return true;
            //if this line is parallel to the y-axis and other line is parallel to the x-axis
        } else if (doubleEquals(this.x1, this.x2) && doubleEquals(other.y1, other.y2)) {
            //if they share an x value
            if ((other.x2 <= this.x1 && this.x1 <= other.x1) || (other.x2 >= this.x1 && this.x1 >= other.x1)) {
                //if they share a y value
                if (this.lowestY(this) <= other.y1 && other.y1 <= this.highestY(this)) {
                    //if the lines intersect return the intersection point
                    return true;
                }
            }
            //if this line is parallel to the x-axis and other line is parallel to the y-axis
        } else if (doubleEquals(this.y1, this.y2) && doubleEquals(other.x1, other.x2)) {
            //check if they share an x point value
            if ((this.x2 <= other.x1 && other.x1 <= this.x1) || (this.x2 >= other.x1 && other.x1 >= this.x1)) {
                //if they share a y value
                if (other.lowestY(other) <= this.y1 && this.y1 <= other.highestY(other)) {
                    //if the lines intersect return the intersection point
                    return true;
                }
            }
            //if this line is parallel to the y-axis and the other line isn't
        } else if (doubleEquals(this.x1, this.x2) && !doubleEquals(other.x1, other.x2)) {
            //if they share an x point value
            if ((other.x2 <= this.x1 && this.x1 <= other.x1) || (other.x2 >= this.x1 && this.x1 >= other.x1)) {
                //calculate the y intersection value
                y = m2 * this.x1 + n2;
                //calculate the x intersection value
                x = (y - n2) / m2;
                //if the y value is in range of the line this
                if (this.highestY(this) >= y && y >= this.lowestY(this)) {
                    //if the lines intersect return the intersection point
                    return true;
                }
            }
            //if other line is parallel to the y-axis and the line this isn't
        } else if (doubleEquals(other.x1, other.x2) && !doubleEquals(this.x1, this.x2)) {
            //if they share an x point value
            if ((this.x2 <= other.x1 && other.x1 <= this.x1) || (this.x2 >= other.x1 && other.x1 >= this.x1)) {
                //calculate the y intersection value
                y = m1 * other.x1 + n1;
                //calculate the x intersection value
                x = (y - n1) / m1;
                //if the y value is in range of the line this
                if (other.highestY(other) >= y && y >= other.lowestY(other)) {
                    //if the lines intersect return the intersection point
                    return true;
                }
            }
            //if this line is parallel to the x-axis and the other line isn't
        } else if (doubleEquals(this.y1, this.y2) && !doubleEquals(other.y1, other.y2)) {
            //if they share an y point value
            if ((other.y2 <= this.y1 && this.y1 <= other.y1) || (other.y2 >= this.y1 && this.y1 >= other.y1)) {
                //calculate the x intersection value
                x = (this.y1 - n2) / m2;
                //calculate the y intersection value
                y = m2 * x + n2;
                //if the x value is in range of the line this
                if (this.smallestX(this) <= x && x <= this.biggestX(this)) {
                    //if the lines intersect return the intersection point
                    return true;
                }
            }
            //if other line is parallel to the x-axis and the line this isn't
        } else if (doubleEquals(other.y1, other.y2) && !doubleEquals(this.y1, this.y2)) {
            //if they share an y point value
            if ((this.y2 <= other.y1 && other.y1 <= this.y1) || (this.y2 >= other.y1 && other.y1 >= this.y1)) {
                //calculate the x intersection value
                x = (other.y1 - n1) / m1;
                //calculate the y intersection value
                y = m1 * x + n1;
                //if the x value is in range of the line this
                if (other.biggestX(other) >= x && x >= other.smallestX(other)) {
                    //if the lines intersect return the intersection point
                    return true;
                }
            }
        }
        //return false if none of the above happen
        return false;
    }

    /**
     * calculates the intersection point.
     *
     * @param other line
     * @return Returns the intersection point if the lines intersect, null otherwise
     */
    public Point intersectionWith(Line other) {
        double m1, m2, n1, n2, x, y;
        //calculate slope of this
        m1 = ((this.y2 - this.y1) / (this.x2 - this.x1));
        //calculate slope of other
        m2 = ((other.y2 - other.y1) / (other.x2 - other.x1));
        //calculate the n value in the straight line equation
        n1 = this.y1 - (m1 * this.x1);
        //calculate the n value in the straight line equation
        n2 = other.y2 - (m2 * other.x2);
        //if the lines meet at the tip return the meeting point
        if (this.start().equals(other.end())) {
            return this.start();
            //if the lines meet at the tip return the meeting point
        } else if (this.end().equals(other.start())) {
            return this.end();
        }
        //if this line is parallel to the x-axis and other line is parallel to the y-axis
        if (doubleEquals(this.y1, this.y2) && doubleEquals(other.x1, other.x2)) {
            //check if they share an x point value
            if ((this.x2 <= other.x1 && other.x1 <= this.x1) || (this.x2 >= other.x1 && other.x1 >= this.x1)) {
                //if they share a y value
                if (other.lowestY(other) <= this.y1 && this.y1 <= other.highestY(other)) {
                    //if the lines intersect return the intersection point
                    return new Point(other.x1, this.y1);
                }
            }
        }
        //if this line is parallel to the y-axis and other line is parallel to the x-axis
        if (doubleEquals(this.x1, this.x2) && doubleEquals(other.y1, other.y2)) {
            //if they share an x value
            if ((other.x2 <= this.x1 && this.x1 <= other.x1) || (other.x2 >= this.x1 && this.x1 >= other.x1)) {
                //if they share a y value
                if (this.lowestY(this) <= other.y1 && other.y1 <= this.highestY(this)) {
                    //if the lines intersect return the intersection point
                    return new Point(this.x1, other.y1);
                }
            }
        }
        //if this line is parallel to the y-axis and the other line isn't
        if (doubleEquals(this.x1, this.x2) && !doubleEquals(other.x1, other.x2)) {
            //if they share an x point value
            if ((other.x2 <= this.x1 && this.x1 <= other.x1) || (other.x2 >= this.x1 && this.x1 >= other.x1)) {
                //calculate the y intersection value
                y = m2 * this.x1 + n2;
                //calculate the x intersection value
                x = (y - n2) / m2;
                //if the y value is in range of the line this
                if (this.highestY(this) >= y && y >= this.lowestY(this)) {
                    //if the lines intersect return the intersection point
                    return new Point(x, y);
                }
            }
        }
        //if other line is parallel to the y-axis and the line this isn't
        if (doubleEquals(other.x1, other.x2) && !doubleEquals(this.x1, this.x2)) {
            //if they share an x point value
            if ((this.x2 <= other.x1 && other.x1 <= this.x1) || (this.x2 >= other.x1 && other.x1 >= this.x1)) {
                //calculate the y intersection value
                y = m1 * other.x1 + n1;
                //calculate the x intersection value
                x = (y - n1) / m1;
                //if the y value is in range of the line this
                if (other.highestY(other) >= y && y >= other.lowestY(other)) {
                    //if the lines intersect return the intersection point
                    return new Point(x, y);
                }
            }
        }
        //if this line is parallel to the x-axis and the other line isn't
        if (doubleEquals(this.y1, this.y2) && !doubleEquals(other.y1, other.y2)) {
            //if they share an y point value
            if ((other.y2 <= this.y1 && this.y1 <= other.y1) || (other.y2 >= this.y1 && this.y1 >= other.y1)) {
                //calculate the x intersection value
                x = (this.y1 - n2) / m2;
                //calculate the y intersection value
                y = m2 * x + n2;
                //if the x value is in range of the line this
                if (this.smallestX(this) <= x && x <= this.biggestX(this)) {
                    //if the lines intersect return the intersection point
                    return new Point(x, y);
                }
            }
        }
        //if other line is parallel to the x-axis and the line this isn't
        if (doubleEquals(other.y1, other.y2) && !doubleEquals(this.y1, this.y2)) {
            //if they share an y point value
            if ((this.y2 <= other.y1 && other.y1 <= this.y1) || (this.y2 >= other.y1 && other.y1 >= this.y1)) {
                //calculate the x intersection value
                x = (other.y1 - n1) / m1;
                //calculate the y intersection value
                y = m1 * x + n1;
                //if the x value is in range of the line this
                if (other.biggestX(other) >= x && x >= other.smallestX(other)) {
                    //if the lines intersect return the intersection point
                    return new Point(x, y);
                }
            }
        }
        //if the lines are the same
        if (this.equals(other)) {
            return null;
        }
        //if the slopes are the same and the lines overlap
        if (doubleEquals(m1, m2) && (this.length() + other.length() > this.highestY(other) - this.lowestY(other))) {
            return null;
        }
        //calculate the y intersection value
        x = ((n2 - n1) / (m1 - m2));
        //calculate the x intersection value
        y = (m1 * x + n1);
        //create an intersection point
        Point intersectionPoint = new Point(x, y);
        //if the lines intersect return the intersection point
        if (this.isIntersecting(other)) {
            return intersectionPoint;
        }
        return null;
    }

    /**
     * @param other line
     * @return return true if the lines are equal, false otherwise
     */
    public boolean equals(Line other) {
        Point startA = this.start();
        Point endA = this.end();
        Point startB = other.start();
        Point endB = other.end();
        return startA.equals(startB) && endA.equals(endB);
    }

    /**
     * this method returns the closest intersection point with a rectangle according to the start of the line.
     *
     * @param rect rectangle
     * @return closest intersection point to start of line
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        //create a list of intersection points
        List<Point> intersectionList;
        intersectionList = rect.intersectionPoints(this);
        //if there are no intersections return null
        if (intersectionList.isEmpty()) {
            return null;
        }
        int minIndex = 0;
        //check the distance between the start of the line to every intersection point
        for (int i = 1; i < intersectionList.size(); i++) {
            //if the distance from the current intersection is closer than from the previous, save the point index.
            if (this.start().distance(intersectionList.get(i)) < this.start().distance(
                    intersectionList.get(minIndex))) {
                minIndex = i;
            }
        }
        //return the closest intersection point from the start of the line
        return intersectionList.get(minIndex);

    }
}

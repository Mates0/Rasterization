package cz.educanet.tranformations.logic;

import cz.educanet.tranformations.logic.models.Coordinate;

import java.util.HashSet;
import java.util.Set;

public class ScreenManager {

    private Set<Coordinate> selectedPoints = new HashSet<>();

    public void select(Coordinate coordinate) {
        selectedPoints.add(coordinate);
    }

    public void unselect(Coordinate coordinate) {
        selectedPoints.remove(coordinate);
    }

    public boolean isSelected(Coordinate coordinate) {
        return selectedPoints.contains(coordinate);
    }

    public Set<Coordinate> getSelectedPoints() {
        return selectedPoints;
    }

    public boolean isFilledIn(Coordinate coordinate) { // TODO: Implement this
        Coordinate[] coords = selectedPoints.toArray(new Coordinate[] {});
        if (coords.length == 3) {
            Coordinate arr0 = coords[0];
            Coordinate arr1 = coords[1];
            Coordinate arr2 = coords[2];

            double cord0x = arr0.getX();
            double cord0y = arr0.getY();
            double cord1x = arr1.getX();
            double cord1y = arr1.getY();
            double cord2x = arr2.getX();
            double cord2y = arr2.getY();

            boolean first = false;
            boolean second = false;
            boolean third = false;

            double a = (cord1y - cord0y) / (cord1x - cord0x);
            double b = cord0y - a * cord0x;

            double a2 = (cord2y - cord1y) / (cord2x - cord1x);
            double b2 = cord1y - a2 * cord1x;

            double a3 = (cord0y - cord2y) / (cord0x - cord2x);
            double b3 = cord2y - a3 * cord2x;

            if (cord2y > a * cord2y + b) {
                if (coordinate.getY() > a * coordinate.getX() + b)
                    first = true;
                else
                    first = false;
            }

            if (cord2y < a * cord2y + b) {
                if (coordinate.getY() < a * coordinate.getX() + b)
                    first = true;
                else
                    first = false;
            }

            if (cord0y > a2 * cord0y + b2) {
                if (coordinate.getY() > a2 * coordinate.getX() + b2)
                    second = true;
                else
                    second = false;
            }

            if (cord0y < a2 * cord0y + b2) {
                if (coordinate.getY() < a2 * coordinate.getX() + b2)
                    second = true;
                else
                    second = false;
            }

            if (cord1y > a3 * cord1x + b3) {
                if (coordinate.getY() > a3 * coordinate.getX() + b3) {
                    third = true;
                } else {
                    third = false;
                }
            }

            if (cord1y < a3 * cord1x + b3) {
                if (coordinate.getY() < a3 + coordinate.getX() + b3) {
                    third = true;
                } else {
                    third = false;
                }
            }
            if (first && second && third) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }
}
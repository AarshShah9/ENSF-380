package edu.ucalgary.oop;

public enum Directions {
    E {
        @Override
        public String toString() {
            return "East";
        }
    },
    N {
        @Override
        public String toString() {
            return "North";
        }
    },
    NE {
        @Override
        public String toString() {
            return "Northeast";
        }
    },
    NW {
        @Override
        public String toString() {
            return "Northwest";
        }
    },
    S {
        @Override
        public String toString() {
            return "South";
        }
    },
    SE {
        @Override
        public String toString() {
            return "Southeast";
        }
    },
    SW {
        @Override
        public String toString() {
            return "Southwest";
        }
    },
    W {
        @Override
        public String toString() {
            return "West";
        }
    };

    @Override
    public abstract String toString();

}

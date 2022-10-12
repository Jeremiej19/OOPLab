package agh.ics.oop;

public enum MapDirection {
    NORTH {
        public String toString()
        {
            return "północ";
        }
    },
    SOUTH {
        public String toString()
        {
            return "południe";
        }
    },
    WEST {
        public String toString()
        {
            return "wschod";
        }
    },
    EAST {
        public String toString()
        {
            return "zachód";
        }
    };


}

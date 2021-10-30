package gameplay;

public class Field {
    private static final byte LENGTH = 10;

    public void drawDemo() {
        String demoField =
                """
                        1 2 3 4 5 6 7 8 9 10
                        ■ ■ ■ ■ • □ □ □ ■ □ 1
                        • • • • • • • □ ■ □ 2
                        • • • □ • ■ • • • • 3
                        • ■ • □ • ■ • ■ ■ ■ 4
                        • • • □ • ■ • • • • 5
                        ■ • □ □ • • • • ■ • 6
                        • • □ □ • • • • • • 7
                        • • • • • ■ • • • • 8
                        • ■ ■ • • • • • ■ • 9
                        • • • • □ □ □ • ■ • 10""".indent(0);
        System.out.println(demoField);
    }

    public void draw(char[][] ships) {
        StringBuilder sb = new StringBuilder();
        sb.append(" 1 2 3 4 5 6 7 8 9 10\n");
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                sb.append(" ");
                sb.append(convertChar(ships[i][j]));
            }
            sb.append(" ").append(i + 1).append("\n");
        }
        System.out.println(sb);
    }

    private String convertChar(char c) {
        return switch (c) {
            case 'm' -> "•";
            case 1 -> "■";
            default -> "□";
        };
    }
}

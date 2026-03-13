package org.ssh.amen.interview.isa;

import java.util.*;

public class Task {

    public static List<String> getShortestChessKnightPath(String startPos, String endPos) {
        Board board = new Board();

        Position start = new Position(startPos);
        Position end = new Position(endPos);

        Queue<Path> queue = new LinkedList<>();
        queue.add(new Path(Arrays.asList(start), start));

        board.setFieldPath(start, Arrays.asList(start));

        while (!queue.isEmpty() && board.getFieldAt(end).path == null) {
            Path currentPath = queue.poll();

            board.setFieldPath(currentPath.getPosition(), currentPath.path);
            if (currentPath.getPosition().equals(end)){
                break;
            }

            List<Position> allowedMoves = board.getAllowedMovesFrom(currentPath.getPosition());
            for (int i = 0; i < allowedMoves.size(); i++) {
                Field f = board.getFieldAt(allowedMoves.get(i));
                if (!f.hasPath()){
                    List<Position> pathCopy = new ArrayList<>(currentPath.getPath());
                    pathCopy.add(f.getPosition());
                    queue.add(new Path(pathCopy, f.getPosition()));
                }
            }
        }

        if (board.getFieldAt(end).hasPath()) {
            List<Position> path =  board.getFieldAt(end).getPath();
            return path.stream().map(position -> position.toString()).toList();
        }
        return null;
    }


    public static void main(String[] args) {
        System.out.println(getShortestChessKnightPath("b1", "e3"));
    }

    public static class Board {
        Field[][] board = new Field[8][8];

        public Board() {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    board[i][j] = new Field(new Position(i, j));
                }
            }
        }

        public Field getFieldAt(Position p) {
            return board[p.indexX][p.indexY];
        }

        public List<Position> getAllowedMovesFrom(Position startPoint) {
            List<Position> positions = new ArrayList<>();
            for (int x = -2; x <= 2; x++) {
                for (int y = -2; y <= 2; y++) {
                    if (Math.abs(x) != Math.abs(y) && x != 0 && y != 0) {
                        int newX = startPoint.indexX + x;
                        int newY = startPoint.indexY + y;

                        if (newX >= 0 && newX <= 7 && newY >= 0 && newY <= 7) {
                            positions.add(new Position(startPoint.indexX + x, startPoint.indexY + y));
                        }
                    }
                }
            }
            return positions;
        }

        public void setFieldPath(Position position, List<Position> path) {
            getFieldAt(position).path = path;
        }
    }

    public static class Position {
        int indexX;
        int indexY;
        String name;

        public Position(int indexX, int indexY) {
            this.indexX = indexX;
            this.indexY = indexY;
            this.name = new StringBuilder().append((char)(indexX + 'a')).append((char)(indexY + '1')).toString();
        }

        public Position(String name) {
            this.name = name;
            this.indexX = name.charAt(0) - 'a';
            this.indexY = name.charAt(1) - '1';
        }

        @Override
        public String toString() {
            return name;
        }
    }


    public static class Path{
        List<Position> path;
        Position position;

        public Path(List<Position> path, Position position) {
            this.path = path;
            this.position = position;
        }

        public List<Position> getPath() {
            return path;
        }

        public void setPath(List<Position> path) {
            this.path = path;
        }

        public Position getPosition() {
            return position;
        }

        public void setPosition(Position position) {
            this.position = position;
        }

    }

    public static class Field {
        List<Position> path;
        Position position;

        public Field(Position position) {
            this.position = position;
        }

        public boolean hasPath() {
            return path != null;
        }

        public List<Position> getPath() {
            return path;
        }

        public void setPath(List<Position> path) {
            this.path = path;
        }

        public Position getPosition() {
            return position;
        }
    }
}

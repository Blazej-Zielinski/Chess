import model.Board.Board;
import model.Figures.Figure;
import model.Figures.Knight;
import model.Figures.Pawn;
import model.Figures.Queen;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class FigureTest {
    @Test
    public void move_defaultBoard_pawnsPossibleMoves() {
        //given
        int[][] expectedMoves = new int[][]{
                //Możliwe ruchy czarnych pionków
                {16,24},
                {17,25},
                {18,26},
                {19,27},
                {20,28},
                {21,29},
                {22,30},
                {23,31},
                //Możliwe ruchy białych pionków
                {40,32},
                {41,33},
                {42,34},
                {43,35},
                {44,36},
                {45,37},
                {46,38},
                {47,39}
        };
        Board board = new Board(null);
        ArrayList<Pawn> pawsList = new ArrayList<>();

        for(Integer position: board.figuresPosition){
            Figure figure = board.getParticularFigure(position);
            if(figure instanceof Pawn){
                pawsList.add((Pawn) figure);
            }
        }


        int i = 0;
        for(Pawn pawn: pawsList){
            //when
            ArrayList<Integer> possibleMoves = pawn.move(board);
            int[] arr = possibleMoves.stream().mapToInt(j -> j).toArray();

            //then
            Assert.assertArrayEquals(arr,expectedMoves[i]);
            i++;
        }
    }

    @Test
    public void move_defaultBoard_KnightsPossibleMoves() {
        //given
        int[][] expectedMoves = new int[][]{
                //Możliwe ruchy czarnych pionków
                {16,18},
                {21,23},
                //Możliwe ruchy białych pionków
                {40,42},
                {45,47}
        };
        Board board = new Board(null);
        ArrayList<Knight> knightsList = new ArrayList<>();

        for(Integer position: board.figuresPosition){
            Figure figure = board.getParticularFigure(position);
            if(figure instanceof Knight){
                knightsList.add((Knight) figure);
            }
        }


        int i = 0;
        for(Knight knight: knightsList){
            //when
            ArrayList<Integer> possibleMoves = knight.move(board);
            int[] arr = possibleMoves.stream().mapToInt(j -> j).toArray();

            //then
            Assert.assertArrayEquals(arr,expectedMoves[i]);
            i++;
        }
    }

    @Test
    public void move_defaultBoard_QueenPossibleMovesEmpty() {
        //given
        Board board = new Board(null);
        ArrayList<Queen> queensList = new ArrayList<>();

        for(Integer position: board.figuresPosition){
            Figure figure = board.getParticularFigure(position);
            if(figure instanceof Queen){
               queensList.add((Queen) figure);
            }
        }


        int i = 0;
        for(Queen queen: queensList){
            //when
            ArrayList<Integer> possibleMoves = queen.move(board);

            //then
            Assert.assertEquals(0, possibleMoves.size());
            i++;
        }
    }
}

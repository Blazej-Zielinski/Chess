package model.Figures;

import model.Board.Board;

import java.util.ArrayList;

public class Knight extends Figure {

    public Knight(String filename, boolean isWhite, int position) {
        super(filename, isWhite, position);
    }

    @Override
    public ArrayList<Integer> move(Board board) {
        ArrayList<Integer> possibleMoves = new ArrayList<Integer>();

        //Basic moves
        if(!(position%8==0)){
            possibleMoves.add(position+15);
            possibleMoves.add(position-17);
            if(!(position%8==1)){
                possibleMoves.add(position+6);
                possibleMoves.add(position-10);
            }
        }

        if(!((position+1)%8==0)){
            possibleMoves.add(position+17);
            possibleMoves.add(position-15);
            if(!((position+2)%8==0)){
                possibleMoves.add(position+10);
                possibleMoves.add(position-6);
            }
        }

        for(Integer i=0;i<possibleMoves.size();i++){
            if(possibleMoves.get(i) <0 || possibleMoves.get(i)>63){
                Integer memberToDelete=possibleMoves.get(i);
                possibleMoves.remove(memberToDelete);
            }
        }

        //---------------------Bicie figur i gdy figury zasłaniają ruch
        ArrayList<Integer> membersToDelete = new ArrayList<>();
        for (Integer x : board.figuresPosition) {
            for (Integer i : possibleMoves) {
                if (x.equals(i)) {

                    if (isFiguresDifferentColor(board.getParticularFigure(i))) {
                        setFigureToKill(board.getParticularFigure(i));
                    } else {
                        membersToDelete.add(i);
                    }

                }
            }
        }

        for (Integer x : membersToDelete) {
            possibleMoves.remove(x);
        }
        return possibleMoves;
    }

}

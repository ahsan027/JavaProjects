import java.util.*;

public class TicTakToe{

    static ArrayList<Integer> player1Positions = new ArrayList<Integer>();
    static ArrayList<Integer> player2Positions = new ArrayList<Integer>();


    public static void main(String[] args) {
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-','+', '-', '+','-'},
                {' ','|',' ', '|', ' '},
                {'-','+', '-', '+','-'},
                {' ', '|', ' ', '|', ' '}};

        playGame(gameBoard);

        while(true){
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter Your number(0-9):");
            int num = scan.nextInt();

            while(player1Positions.contains(num) || player2Positions.contains(player1Positions)){
                System.out.println("Position is already in  use");
                num = scan.nextInt();


            };

            System.out.println(num);



            PlaceMent(gameBoard, num, "player1");

            String result = CheckWinner();



            Random rand = new Random();
            int player2rand = rand.nextInt(9) + 1;

            while(player1Positions.contains(player2rand) || player2Positions.contains(player1Positions)){
                player2rand = rand.nextInt(9)+1;
            };


            PlaceMent(gameBoard, player2rand , "player2");

            playGame(gameBoard);

            result = CheckWinner();
            if(result.length() > 0){
                System.out.println(result);
                break;
            }


        }





    };




    public static void playGame(char[][] gameBoard){
            for(char[] row : gameBoard){
                for( char c : row){
                    System.out.print(c);
                };
                System.out.println();

        };




        };


    public static void PlaceMent(char [][] gameBoard, int num , String user){
        char symbol = ' ';

        if(user.equals("player1")){
            player1Positions.add(num);

            symbol = 'X';

        } else if(user.equals("player2")){
            player2Positions.add(num);

            symbol = 'O';

        }


        switch(num){
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2]= symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;

        };
    };

    public static String CheckWinner(){

        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List lowRow = Arrays.asList(7, 8, 9);
        List upCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List lowCol = Arrays.asList(3, 6, 9);
        List QCorner = Arrays.asList(1, 5, 9);
        List PCorner = Arrays.asList(3, 5, 7);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(lowRow);
        winning.add(upCol);
        winning.add(midCol);
        winning.add(lowCol);
        winning.add(QCorner);
        winning.add(PCorner);

        for(List l : winning){
            if(player1Positions.containsAll(l)){

                return "Congratulations Player 1 Won";

            } else if(player2Positions.containsAll(l)){

                return "Congratulations Player 2 Won";

            } else if(player1Positions.size() + player2Positions.size() == 9){

                return "Draw/ Board full";

            }


        };


        return " ";

    };




    };





package Aggravation;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BoardGame extends Application {
    ///// GLOBAL VARIABLES /////
    // Track the turn number
    int currentTurn = 0;
    // Track which player turn it is: 0 = player 1, 1 = player 2, etc
    int currentPlayer = 0;
    // Create the Dice
    int dice = 0;
    // Used for end of array positioning
    int difference = 0;
    // Opponent's piece
    int opponentPiece = 0;
    // Number remaining for home row (how far can the player move into the home row?)
    int differenceHome = 0;
    // Tracks movement inside the home row
    int insideHomeRow = 0;
    int insideHomeRowOriginal = 0;
    // Tracks if the player is starting the turn in the center position or not
    boolean centerSpot = false;
    // Tracks which player is in the center spot, 6 = empty
    int centerPlayer = 6;

    // Game board array tracks what pieces of what players are in what positions
    // 6 = empty space (no piece in position)
    // 0-5 are players (0 = p1, 1 = p2, etc.)
    int[] board = new int[84];

    // This tracks specific values needed for each player
    // playerBoard[][0] = their base-exit point onto the board, playerBoard[][1] = the last space before they enter their home row
    // playerBoard[0][] is player 1, playerBoard[1][] is player 2, etc.
    int[][] playerBoard = new int[][]{
            {0, 83},
            {14, 13},
            {28, 27},
            {42, 41},
            {56, 55},
            {70, 69}
    };

    // Player base
    // Each number correlates to a player and is equal to how many pieces are in their base
    // playerBases[0] is player 1, etc.
    int[] playerBases = new int[] {3, 3, 3, 3, 3, 3};
    // Player colors
    String[] playerColors = new String[]{"Yellow", "Green", "Magenta", "Navy", "Red", "Orange"};
    // Player home rows, 0 = an empty spot
    int[][] playerHomes = new int[][]{
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
    };

    // This is used to control various game states for testing purposes only
    boolean devTest = false;

    // Circle Arrays (this is used for the actual design of the board)
    Circle[] circleYellow = new Circle[4];
    Circle[] circleBlue = new Circle[4];
    Circle[] circleGreen = new Circle[4];
    Circle[] circleRed = new Circle[4];
    Circle[] circleOrange = new Circle[4];
    Circle[] circleMagenta = new Circle[4];
    Circle[] circleMain = new Circle[84];

    // Button Arrays (this is used for the actual design of the board)
    Button[] buttonYellow = new Button[4];
    Button[] buttonYellowBase = new Button[4];
    Button[] buttonBlue = new Button[4];
    Button[] buttonBlueBase = new Button[4];
    Button[] buttonGreen = new Button[4];
    Button[] buttonGreenBase = new Button[4];
    Button[] buttonRed = new Button[4];
    Button[] buttonRedBase = new Button[4];
    Button[] buttonOrange = new Button[4];
    Button[] buttonOrangeBase = new Button[4];
    Button[] buttonMagenta = new Button[4];
    Button[] buttonMagentaBase = new Button[4];
    Button[] buttonMain = new Button[84];

    // Center circle
    Circle circleCenterMain = new Circle();
    Button buttonCenter = new Button();

    // Create the base pane for the entire board
    StackPane rootPane = new StackPane();
    // Gridpane (Top of Screen)
    GridPane topPane = new GridPane();
    // Next turn button (goes at top of the screen)
    Button nextTurn = new Button("Next Turn");
    // Restart Game (goes at top of the screen)
    Button resetGame = new Button("New Game");
    // Open the developer console
    Button devConsole = new Button("Developer Console");
    // Borderpane
    BorderPane borderPane = new BorderPane();

    // MAIN METHOD
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        /**** Circle Pane Zero (Runs straight up and down pane in center of board) *****/
        GridPane circlePaneZero = new GridPane();    // Create Circle Pane Zero
        circlePaneZero.setHgap(2);                // Create gaps between circles.
        circlePaneZero.setVgap(2);
        /*************** Circle Pane One *********************************************/
        GridPane circlePaneOne = new GridPane();        // Create Circle Pane One
        circlePaneOne.setHgap(2);                        // Create gaps between circles.
        circlePaneOne.setVgap(2);
        /*************** Circle Pane Two *********************************************/
        GridPane circlePaneTwo = new GridPane();
        circlePaneTwo.setHgap(2);
        circlePaneTwo.setVgap(2);
        /*************** Button Pane Zero *********************************************/
        GridPane paneZero = new GridPane();
        paneZero.setHgap(6);
        paneZero.setVgap(6);
        /*************** Button Pane One *********************************************/
        GridPane paneOne = new GridPane();
        paneOne.setHgap(6);
        paneOne.setVgap(6);
        /*************** Button Pane Two *********************************************/
        GridPane paneTwo = new GridPane();            // Creating gridpane
        paneTwo.setHgap(6);                            // Creating gaps for Buttons
        paneTwo.setVgap(6);
        /*************** Star Pane *********************************************/
        GridPane starPane = new GridPane();
        starPane.setHgap(1);
        starPane.setVgap(1);             // Create gaps between bases.
        /*************** Circle Center and Circle Rim *********************************************/
        Circle circleCenter = new Circle();
        Circle circleRim = new Circle();
        /************** Home Base Rectangles *******************/
        Rectangle homeRectangleYellow = new Rectangle(0, 0, 100, 170);
        homeRectangleYellow.setFill(Color.YELLOW);
        Rectangle homeRectangleBlue = new Rectangle(0, 0, 100, 170);
        homeRectangleBlue.setFill(Color.NAVY);
        Rectangle homeRectangleGreen = new Rectangle(0, 0, 100, 170);
        homeRectangleGreen.setFill(Color.GREEN);
        Rectangle homeRectangleRed = new Rectangle(0, 0, 100, 170);
        homeRectangleRed.setFill(Color.RED);
        Rectangle homeRectangleOrange = new Rectangle(0, 0, 100, 170);
        homeRectangleOrange.setFill(Color.ORANGE);
        Rectangle homeRectangleWhite = new Rectangle(0, 0, 100, 170);
        homeRectangleWhite.setFill(Color.MAGENTA);
        /******************* Start Base Colors  **************/
        Rectangle rectangleBlueBase = new Rectangle(0, 0, 210, 65);
        rectangleBlueBase.setFill(Color.NAVY);
        Rectangle rectangleYellowBase = new Rectangle(0, 0, 210, 65);
        rectangleYellowBase.setFill(Color.YELLOW);
        Rectangle rectangleWhiteBase = new Rectangle(0, 0, 210, 65);
        rectangleWhiteBase.setFill(Color.MAGENTA);
        Rectangle rectangleRedBase = new Rectangle(0, 0, 210, 65);
        rectangleRedBase.setFill(Color.RED);
        Rectangle rectangleGreenBase = new Rectangle(0, 0, 210, 65);
        rectangleGreenBase.setFill(Color.GREEN);
        Rectangle rectangleOrangeBase = new Rectangle(0, 0, 210, 65);
        rectangleOrangeBase.setFill(Color.ORANGE);
        /************** Background Panes (Make the colors for the game board) ***********/
        GridPane colorPaneZero = new GridPane();    // Create Circle Pane Zero
        GridPane colorPaneOne = new GridPane();    // Create Circle Pane One
        GridPane colorPaneTwo = new GridPane();    // Create Circle Pane Two
        /**************** Base Button Panes *************************************/
        GridPane basePaneZero = new GridPane();    // Create Circle Pane Zero
        GridPane basePaneOne = new GridPane();    // Create Circle Pane One
        GridPane basePaneTwo = new GridPane();    // Create Circle Pane Two
        /********************* Home Base Colors GridPanes ****************************/
        GridPane homePaneZero = new GridPane();    // Create home Pane Zero
        homePaneZero.setHgap(2);
        homePaneZero.setVgap(2);
        GridPane homePaneOne = new GridPane();    // Create home Pane One
        homePaneOne.setHgap(2);
        homePaneOne.setVgap(2);
        GridPane homePaneTwo = new GridPane();    // Create home Pane Two
        homePaneTwo.setHgap(2);
        homePaneTwo.setVgap(2);

        // Call all of the classes that build the board
        CircleArray.generateCircleArray(circleMain);
        CirclePaneZero.circlePaneZero(circlePaneZero, circleMain, circleCenterMain, circleYellow, circleBlue);
        CirclePaneOne.circlePaneOne(circlePaneOne, circleMain, circleGreen, circleRed);
        CirclePaneTwo.circlePaneTwo(circlePaneTwo, circleMain, circleOrange, circleMagenta);
        ButtonArray.buttonArray(buttonMain);
        ButtonPaneZero.buttonPaneZero(paneZero, buttonMain, buttonCenter, buttonYellow, buttonBlue);
        ButtonPaneOne.buttonPaneOne(paneOne, buttonMain, buttonGreen, buttonRed);
        ButtonPaneTwo.buttonPaneTwo(paneTwo, buttonMain, buttonOrange, buttonMagenta);
        Stars.starGenerator(starPane);
        Circles.circleGenerator(circleCenter, circleRim);
        GameBoardColorPanes.colorPanes(colorPaneZero, colorPaneOne, colorPaneTwo, rectangleYellowBase, rectangleBlueBase, rectangleGreenBase,
                rectangleRedBase, rectangleOrangeBase, rectangleWhiteBase);
        BaseButtons.baseButtons(basePaneZero, basePaneOne, basePaneTwo, buttonYellowBase, buttonBlueBase, buttonGreenBase, buttonMagentaBase, buttonRedBase, buttonOrangeBase);
        HomePane.homePane(homePaneZero, homePaneOne, homePaneTwo, homeRectangleYellow, homeRectangleBlue, homeRectangleGreen, homeRectangleRed, homeRectangleOrange, homeRectangleWhite);

        // Establish the rootpane styles
        rootPane.setStyle(
                "-fx-background-color:navy;" +
                        "-fx-min-width: 1250px; " +
                        "-fx-min-height: 1000px; " +
                        "-fx-max-width: 1250px; " +
                        "-fx-max-height: 1000px;"
        );

        // Establish the borderpane contents
        borderPane.setTop(topPane);
        borderPane.setCenter(rootPane);

        /************** SceneGenerator *****************************************************/
        Scene scene = new Scene(borderPane);
        rootPane.getChildren().addAll(colorPaneZero, colorPaneOne, colorPaneTwo, basePaneZero, basePaneOne, basePaneTwo, starPane,
                homePaneZero, homePaneOne, homePaneTwo, circleRim, circleCenter, circlePaneTwo, circlePaneOne, circlePaneZero, paneTwo, paneOne, paneZero);
        primaryStage.setTitle("ShowGridPane"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        // Set up the board array
        for (int i = 0; i <= 83; i++) {
            board[i] = 6;
        }
        // Once the board is set up, call turn to begin the game
        turn();
    }
    
    // PLAYER TURN
    public void turn() {
        // Roll the dice
        dice = (int) (Math.random() * 6) + 1;
        // Top of screen update
        topPane.getChildren().clear();
        topPane.setHgap(50);
        topPane.setMinSize(50, 50);
        topPane.setAlignment(Pos.CENTER);
        Text topCurrentTurn = new Text("Current Turn: " + currentTurn);
        topPane.add(topCurrentTurn, 0, 0);
        Text topCurrentPlayer = new Text("Current Player: " + playerColors[currentPlayer]);
        topPane.add(topCurrentPlayer, 1, 0);
        Text topDice = new Text("Dice Roll: " + dice);
        topPane.add(topDice, 3, 0);
        topPane.add(nextTurn, 10, 0);
        topPane.add(resetGame, 11, 0);
        topPane.add(devConsole, 12, 0);
        borderPane.setTop(topPane);
        nextTurn.setOnAction(e -> { endTurn(); });
        resetGame.setOnAction(e -> { newGame(); });

        ///// DEVELOPER CONSOLE /////
        Button opponent = new Button("Land On Opponent");
        opponent.setOnAction(e -> {
            newGame();
            board[4] = 0;
            buttonMain[4].setStyle(
                    "-fx-background-radius: 5em; " +
                            "-fx-min-width: 30px; " +
                            "-fx-min-height: 30px; " +
                            "-fx-max-width: 30px; " +
                            "-fx-max-height: 30px;" +
                            "-fx-background-color: Yellow");
            board[10] = 1;
            buttonMain[10].setStyle(
                    "-fx-background-radius: 5em; " +
                            "-fx-min-width: 30px; " +
                            "-fx-min-height: 30px; " +
                            "-fx-max-width: 30px; " +
                            "-fx-max-height: 30px;" +
                            "-fx-background-color: Green");
            playerBases[0] -= 1;
            playerBases[1] -= 1;
            base();
            devTest = true;
            turn();
        });
        Button home = new Button("Winning the Game");
        home.setOnAction(e -> {
            newGame();
            for (int i = 1; i < 4; i++) {
                playerHomes[0][i] = 1;
                homeRow();
            }
            board[78] = 0;
            buttonMain[78].setStyle(
                    "-fx-background-radius: 5em; " +
                            "-fx-min-width: 30px; " +
                            "-fx-min-height: 30px; " +
                            "-fx-max-width: 30px; " +
                            "-fx-max-height: 30px;" +
                            "-fx-background-color: Yellow");
            playerBases[0] = -1;
            base();
            devTest = true;
            turn();
        });
        Button center = new Button("Leaving the Center Position");
        center.setOnAction(e -> {
            newGame();
            buttonCenter.setStyle(
                    "-fx-background-radius: 5em; " +
                            "-fx-min-width: 30px; " +
                            "-fx-min-height: 30px; " +
                            "-fx-max-width: 30px; " +
                            "-fx-max-height: 30px;" +
                            "-fx-background-color: Yellow");
            centerPlayer = 0;
            centerSpot = true;
            playerBases[0] -= 1;
            base();
            devTest = true;
            turn();
        });
        devConsole.setOnAction(e -> { DevConsole.display(opponent, home, center); });
        if (devTest == true) {
            currentPlayer = 0;
            dice = 6;
        }

        ///// LEAVING THE PLAYER BASE /////
        if ((dice == 1 || dice == 6) && (playerBases[currentPlayer] >= 0) && (board[playerBoard[currentPlayer][0]] != currentPlayer)) {
            // Disable the next turn button
            nextTurn.setDisable(true);
            // Illuminate the option to show the player they can leave their base
            circleMain[playerBoard[currentPlayer][0]].setFill(Color.BLACK);
            // This sections adds a click event to let the player out of their base
            buttonMain[playerBoard[currentPlayer][0]].setOnAction(e -> {
                buttonMain[playerBoard[currentPlayer][0]].setStyle(
                        "-fx-background-radius: 5em; " +
                                "-fx-min-width: 30px; " +
                                "-fx-min-height: 30px; " +
                                "-fx-max-width: 30px; " +
                                "-fx-max-height: 30px;" +
                                "-fx-background-color: " + playerColors[currentPlayer]);
                // Remove one total from the player base (this number is how many pieces are in the player base)
                playerBases[currentPlayer] -= 1;
                // Checks if there is an opponent piece in position
                if (board[playerBoard[currentPlayer][0]] < 6) {
                    opponentPiece = board[playerBoard[currentPlayer][0]];
                    // Adds one to the player base (this number is how many pieces are in the player base)
                    playerBases[opponentPiece] += 1;
                }
                // Generates the player bases
                base();
                // Sets the "home" position for this player to show there is a piece there
                board[playerBoard[currentPlayer][0]] = currentPlayer;
                // Board clean up
                boardCleanup();
            });
        }
        // Main loop that checks each board position and compares it to the current player to see if its their piece
        for (int i = 0; i < 84; i++) {
            int position = i;
            if (board[i] == currentPlayer) {
                int positionPotential = position + dice;
                // endOfArray checks if the piece is about to go over the board array
                boolean endOfArray = false;
                if (positionPotential > 83) {
                    endOfArray = true;
                    // Difference calculates if the piece is about to go over the board array and if it is, how far over
                    difference = positionPotential - 83;
                }
                // playerConflict checks to make sure the player doesn't bypass their own pieces on the board
                boolean playerConflict = false;
                for (int j = 1; j <= dice; j++) {
                    if ((position + j < 84) && (board[position + j] == currentPlayer)) {
                        playerConflict = true;
                        break;
                    } else if ((difference - j >= 0) && (board[difference - j] == currentPlayer)) {
                        playerConflict = true;
                        break;
                    }
                }
                // closeToHomeRow checks if the player is about to go past their home row entry position
                boolean closeToHomeRow = false;
                if ((positionPotential > playerBoard[currentPlayer][1]) && (position < playerBoard[currentPlayer][0]) && (currentPlayer > 0)) {
                    for (int k = 1; k <= dice; k++) {
                        if ((position + k < playerBoard[currentPlayer][0]) && (board[position + k] == currentPlayer)) {
                            closeToHomeRow = false;
                            break;
                        } else if (k == dice) {
                            closeToHomeRow = true;
                            differenceHome = positionPotential - playerBoard[currentPlayer][1];
                        }
                    }
                } else if ((positionPotential > playerBoard[currentPlayer][1]) && (currentPlayer == 0)) {
                    for (int k = 1; k <= dice; k++) {
                        if ((position + k < 84) && (board[position + k] == currentPlayer)) {
                            closeToHomeRow = false;
                            break;
                        } else if (k == dice) {
                            closeToHomeRow = true;
                            differenceHome = positionPotential - playerBoard[currentPlayer][1];
                        }
                    }
                }
                // homeRowMove determines if the player is capable of moving off the board array into the home row without skipping any of their own pieces
                boolean homeRowMove = false;
                if ((differenceHome > 0) && (differenceHome <= 4) && (closeToHomeRow)) {
                    differenceHome -= 1;
                    for (int j = 0; j <= differenceHome; j++) {
                        if (playerHomes[currentPlayer][j] == 1) {
                            break;
                        } else if (j == differenceHome) {
                            homeRowMove = true;
                        }
                    }
                }
                // opponentConflict checks if the player is about to land on an opponent's piece
                boolean opponentConflict = false;
                if ((difference == 0) && (board[positionPotential] < 6) && (board[positionPotential] != currentPlayer) && (!playerConflict) && (!closeToHomeRow)) {
                    opponentConflict = true;
                    opponentPiece = board[positionPotential];
                } else if ((difference > 0) && (board[(difference - 1)] < 6) && (board[(difference - 1)] != currentPlayer) && (!playerConflict) && (!closeToHomeRow)) {
                    opponentConflict = true;
                    opponentPiece = board[(difference - 1)];
                }
                // starSpot checks if the player is starting their turn in one of the six star positions around the center
                boolean starSpot = false;
                for (int j = 7; j <= 77; j += 14) {
                    if ((board[j] == currentPlayer) && (centerPlayer != currentPlayer)) {
                        starSpot = true;
                    }
                }
                ///// NORMAL MOVE /////
                if ((!closeToHomeRow) && (!playerConflict) && (!opponentConflict)) {
                    // Disable the next turn button
                    nextTurn.setDisable(true);
                    if (!endOfArray) {
                        // Illuminate the move option
                        circleMain[positionPotential].setFill(Color.BLACK);
                        // Set the click action event
                        buttonMain[positionPotential].setOnAction(e -> {
                            normalMove(position, positionPotential);
                        });
                    } else if (endOfArray) {
                        // Illuminate the move option
                        circleMain[(difference - 1)].setFill(Color.BLACK);
                        // Set the click action event
                        buttonMain[(difference - 1)].setOnAction(e -> {
                            normalMove(position, (difference - 1));
                        });
                    }
                }
                ///// LANDING ON OPPONENTS /////
                if (opponentConflict) {
                    // Disable the next turn button
                    nextTurn.setDisable(true);
                    if (!endOfArray) {
                        // Illuminate the move option
                        circleMain[positionPotential].setFill(Color.BLACK);
                        // Set the click action event
                        buttonMain[positionPotential].setOnAction(e -> {
                            landOnOpponent(position, positionPotential);
                        });
                    } else if (endOfArray) {
                        // Illuminate the move option
                        circleMain[(difference - 1)].setFill(Color.BLACK);
                        // Set the click action event
                        buttonMain[(difference - 1)].setOnAction(e -> {
                            landOnOpponent(position, (difference - 1));
                        });
                    }
                }
                ///// MOVING INTO THE HOME ROW /////
                if (homeRowMove) {
                    // Disable the next turn button
                    nextTurn.setDisable(true);
                    if (currentPlayer == 0) {
                        circleYellow[differenceHome].setFill(Color.BLACK);
                        buttonYellow[differenceHome].setOnAction(e -> {
                            // Update the player position in playerHomes array to show that it's occupied
                            playerHomes[currentPlayer][differenceHome] = 1;
                            // Remove the illumination to show the move has been made
                            circleYellow[differenceHome].setFill(Color.WHITE);
                            // Call the homeRow method to color in the updated button
                            homeRow();
                            // Set the current player position in the board array to 6 (empty) and remove that piece
                            board[position] = 6;
                            buttonMain[position].setStyle(
                                    "-fx-background-radius: 5em; " +
                                            "-fx-min-width: 30px; " +
                                            "-fx-min-height: 30px; " +
                                            "-fx-max-width: 30px; " +
                                            "-fx-max-height: 30px;");
                            // Board clean up
                            boardCleanup();
                        });
                    } else if (currentPlayer == 1) {
                        circleGreen[differenceHome].setFill(Color.BLACK);
                        buttonGreen[differenceHome].setOnAction(e -> {
                            // Update the player position in playerHomes array to show that it's occupied
                            playerHomes[currentPlayer][differenceHome] = 1;
                            // Remove the illumination to show the move has been made
                            circleGreen[differenceHome].setFill(Color.WHITE);
                            // Call the homeRow method to color in the updated button
                            homeRow();
                            // Set the current player position in the board array to 6 (empty) and remove that piece
                            board[position] = 6;
                            buttonMain[position].setStyle(
                                    "-fx-background-radius: 5em; " +
                                            "-fx-min-width: 30px; " +
                                            "-fx-min-height: 30px; " +
                                            "-fx-max-width: 30px; " +
                                            "-fx-max-height: 30px;");
                            // Board clean up
                            boardCleanup();
                        });
                    } else if (currentPlayer == 2) {
                        circleMagenta[differenceHome].setFill(Color.BLACK);
                        buttonMagenta[differenceHome].setOnAction(e -> {
                            // Update the player position in playerHomes array to show that it's occupied
                            playerHomes[currentPlayer][differenceHome] = 1;
                            // Remove the illumination to show the move has been made
                            circleMagenta[differenceHome].setFill(Color.WHITE);
                            // Call the homeRow method to color in the updated button
                            homeRow();
                            // Set the current player position in the board array to 6 (empty) and remove that piece
                            board[position] = 6;
                            buttonMain[position].setStyle(
                                    "-fx-background-radius: 5em; " +
                                            "-fx-min-width: 30px; " +
                                            "-fx-min-height: 30px; " +
                                            "-fx-max-width: 30px; " +
                                            "-fx-max-height: 30px;");
                            // Board clean up
                            boardCleanup();
                        });
                    } else if (currentPlayer == 3) {
                        circleBlue[differenceHome].setFill(Color.BLACK);
                        buttonBlue[differenceHome].setOnAction(e -> {
                            // Update the player position in playerHomes array to show that it's occupied
                            playerHomes[currentPlayer][differenceHome] = 1;
                            // Remove the illumination to show the move has been made
                            circleBlue[differenceHome].setFill(Color.WHITE);
                            // Call the homeRow method to color in the updated button
                            homeRow();
                            // Set the current player position in the board array to 6 (empty) and remove that piece
                            board[position] = 6;
                            buttonMain[position].setStyle(
                                    "-fx-background-radius: 5em; " +
                                            "-fx-min-width: 30px; " +
                                            "-fx-min-height: 30px; " +
                                            "-fx-max-width: 30px; " +
                                            "-fx-max-height: 30px;");
                            // Board clean up
                            boardCleanup();
                        });
                    } else if (currentPlayer == 4) {
                        circleRed[differenceHome].setFill(Color.BLACK);
                        buttonRed[differenceHome].setOnAction(e -> {
                            // Update the player position in playerHomes array to show that it's occupied
                            playerHomes[currentPlayer][differenceHome] = 1;
                            // Remove the illumination to show the move has been made
                            circleRed[differenceHome].setFill(Color.WHITE);
                            // Call the homeRow method to color in the updated button
                            homeRow();
                            // Set the current player position in the board array to 6 (empty) and remove that piece
                            board[position] = 6;
                            buttonMain[position].setStyle(
                                    "-fx-background-radius: 5em; " +
                                            "-fx-min-width: 30px; " +
                                            "-fx-min-height: 30px; " +
                                            "-fx-max-width: 30px; " +
                                            "-fx-max-height: 30px;");
                            // Board clean up
                            boardCleanup();
                        });
                    } else if (currentPlayer == 5) {
                        circleOrange[differenceHome].setFill(Color.BLACK);
                        buttonOrange[differenceHome].setOnAction(e -> {
                            // Update the player position in playerHomes array to show that it's occupied
                            playerHomes[currentPlayer][differenceHome] = 1;
                            // Remove the illumination to show the move has been made
                            circleOrange[differenceHome].setFill(Color.WHITE);
                            // Call the homeRow method to color in the updated button
                            homeRow();
                            // Set the current player position in the board array to 6 (empty) and remove that piece
                            board[position] = 6;
                            buttonMain[position].setStyle(
                                    "-fx-background-radius: 5em; " +
                                            "-fx-min-width: 30px; " +
                                            "-fx-min-height: 30px; " +
                                            "-fx-max-width: 30px; " +
                                            "-fx-max-height: 30px;");
                            // Board clean up
                            boardCleanup();
                        });
                    }
                }
                // MOVE INTO THE CENTER SPACE FROM A STAR SPOT
                if (starSpot) {
                    // Illuminate the move option
                    circleCenterMain.setFill(Color.BLACK);
                    // Set the click action event
                    buttonCenter.setOnAction(e -> {
                        buttonCenter.setStyle(
                                "-fx-background-radius: 5em; " +
                                        "-fx-min-width: 30px; " +
                                        "-fx-min-height: 30px; " +
                                        "-fx-max-width: 30px; " +
                                        "-fx-max-height: 30px;" +
                                        "-fx-background-color: " + playerColors[currentPlayer]);
                        int tempPosition = 0;
                        for (int j = 7; j <= 77; j += 14) {
                            if (board[j] == currentPlayer) {
                                board[j] = 6;
                                tempPosition = j;
                                break;
                            }
                        }
                        buttonMain[tempPosition].setStyle(
                                "-fx-background-radius: 5em; " +
                                        "-fx-min-width: 30px; " +
                                        "-fx-min-height: 30px; " +
                                        "-fx-max-width: 30px; " +
                                        "-fx-max-height: 30px;");
                        centerSpot = true;
                        // This checks if the center position is occupied; 6 means that it is empty
                        if (centerPlayer != 6) {
                            opponentPiece = centerPlayer;
                            // Adds one to the player base (this number is how many pieces are in the player base)
                            playerBases[opponentPiece] += 1;
                            base();
                        }
                        centerPlayer = currentPlayer;
                        boardCleanup();
                    });
                }
            }
        }
        ///// LEAVING THE CENTER POSITION /////
        // This makes the click event for leaving the center if there is no movement conflict
        if ((centerSpot) && ((dice == 1) || (dice == 6)) && (centerPlayer == currentPlayer)) {
            for (int j = 7; j <= 77; j += 14) {
                if (board[j] != currentPlayer) {
                    circleMain[j].setFill(Color.BLACK);
                    int temp = j;
                    buttonMain[j].setOnAction(e -> {
                        if (board[temp] < 6) {
                            opponentPiece = board[temp];
                            playerBases[opponentPiece] += 1;
                            base();
                        }
                        buttonMain[temp].setStyle(
                                "-fx-background-radius: 5em; " +
                                        "-fx-min-width: 30px; " +
                                        "-fx-min-height: 30px; " +
                                        "-fx-max-width: 30px; " +
                                        "-fx-max-height: 30px;" +
                                        "-fx-background-color: " + playerColors[currentPlayer]);
                        buttonCenter.setStyle(
                                "-fx-background-radius: 5em; " +
                                        "-fx-min-width: 30px; " +
                                        "-fx-min-height: 30px; " +
                                        "-fx-max-width: 30px; " +
                                        "-fx-max-height: 30px;");
                        // Set the current player position in the board array
                        board[temp] = currentPlayer;
                        centerSpot = false;
                        centerPlayer = 6;
                        boardCleanup();
                    });
                }
            }
        }
        ///// PIECES INSIDE OF HOME ROWS /////
        for (int i = 0; i < 4; i++) {
            insideHomeRowOriginal = i;
            insideHomeRow = i + dice;
            if ((playerHomes[currentPlayer][i] > 0) && (insideHomeRow < 4)) {
                for (int j = i + 1; j <= insideHomeRow; j++) {
                    if (playerHomes[currentPlayer][j] == 1) {
                        break;
                    } else if (j == insideHomeRow) {
                        // Disable the next turn button
                        nextTurn.setDisable(true);
                        int setOriginal = insideHomeRowOriginal;
                        int setMove = insideHomeRow;
                        if (currentPlayer == 0) {
                            circleYellow[setMove].setFill(Color.BLACK);
                            // Set the click action event
                            buttonYellow[setMove].setOnAction(e -> {
                                System.out.println("setMove is " + setMove);
                                buttonYellow[setMove].setStyle(
                                        "-fx-background-radius: 5em; " +
                                                "-fx-min-width: 30px; " +
                                                "-fx-min-height: 30px; " +
                                                "-fx-max-width: 30px; " +
                                                "-fx-max-height: 30px;" +
                                                "-fx-background-color: Yellow");
                                // Remove the illumination to show the move has been made
                                circleYellow[setMove].setFill(Color.WHITE);
                                // Update the player position in playerHomes array to show that it's occupied
                                playerHomes[currentPlayer][setMove] = 1;
                                // Change the color of the button the player piece left
                                buttonYellow[setOriginal].setStyle(
                                        "-fx-background-radius: 5em; " +
                                                "-fx-min-width: 30px; " +
                                                "-fx-min-height: 30px; " +
                                                "-fx-max-width: 30px; " +
                                                "-fx-max-height: 30px;"
                                );
                                // Set the current player position in the board array to empty
                                playerHomes[currentPlayer][setOriginal] = 0;
                                // Board clean up
                                boardCleanup();
                            });
                        } else if (currentPlayer == 1) {
                            circleGreen[setMove].setFill(Color.BLACK);
                            // Set the click action event
                            buttonGreen[setMove].setOnAction(e -> {
                                buttonGreen[setMove].setStyle(
                                        "-fx-background-radius: 5em; " +
                                                "-fx-min-width: 30px; " +
                                                "-fx-min-height: 30px; " +
                                                "-fx-max-width: 30px; " +
                                                "-fx-max-height: 30px;" +
                                                "-fx-background-color: Green");
                                // Remove the illumination to show the move has been made
                                circleGreen[setMove].setFill(Color.WHITE);
                                // Update the player position in playerHomes array to show that it's occupied
                                playerHomes[currentPlayer][setMove] = 1;
                                // Change the color of the button the player piece left
                                buttonGreen[setOriginal].setStyle(
                                        "-fx-background-radius: 5em; " +
                                                "-fx-min-width: 30px; " +
                                                "-fx-min-height: 30px; " +
                                                "-fx-max-width: 30px; " +
                                                "-fx-max-height: 30px;"
                                );
                                // Set the current player position in the board array to empty
                                playerHomes[currentPlayer][setOriginal] = 0;
                                // Board clean up
                                boardCleanup();
                            });
                        } else if (currentPlayer == 2) {
                            circleMagenta[setMove].setFill(Color.BLACK);
                            // Set the click action event
                            buttonMagenta[setMove].setOnAction(e -> {
                                buttonMagenta[setMove].setStyle(
                                        "-fx-background-radius: 5em; " +
                                                "-fx-min-width: 30px; " +
                                                "-fx-min-height: 30px; " +
                                                "-fx-max-width: 30px; " +
                                                "-fx-max-height: 30px;" +
                                                "-fx-background-color: Magenta");
                                // Remove the illumination to show the move has been made
                                circleMagenta[setMove].setFill(Color.WHITE);
                                // Update the player position in playerHomes array to show that it's occupied
                                playerHomes[currentPlayer][setMove] = 1;
                                // Change the color of the button the player piece left
                                buttonMagenta[setOriginal].setStyle(
                                        "-fx-background-radius: 5em; " +
                                                "-fx-min-width: 30px; " +
                                                "-fx-min-height: 30px; " +
                                                "-fx-max-width: 30px; " +
                                                "-fx-max-height: 30px;"
                                );
                                // Set the current player position in the board array to empty
                                playerHomes[currentPlayer][setOriginal] = 0;
                                // Board clean up
                                boardCleanup();
                            });
                        } else if (currentPlayer == 3) {
                            circleBlue[setMove].setFill(Color.BLACK);
                            // Set the click action event
                            buttonBlue[setMove].setOnAction(e -> {
                                buttonBlue[setMove].setStyle(
                                        "-fx-background-radius: 5em; " +
                                                "-fx-min-width: 30px; " +
                                                "-fx-min-height: 30px; " +
                                                "-fx-max-width: 30px; " +
                                                "-fx-max-height: 30px;" +
                                                "-fx-background-color: Navy");
                                // Remove the illumination to show the move has been made
                                circleBlue[setMove].setFill(Color.WHITE);
                                // Update the player position in playerHomes array to show that it's occupied
                                playerHomes[currentPlayer][setMove] = 1;
                                // Change the color of the button the player piece left
                                buttonBlue[setOriginal].setStyle(
                                        "-fx-background-radius: 5em; " +
                                                "-fx-min-width: 30px; " +
                                                "-fx-min-height: 30px; " +
                                                "-fx-max-width: 30px; " +
                                                "-fx-max-height: 30px;"
                                );
                                // Set the current player position in the board array to empty
                                playerHomes[currentPlayer][setOriginal] = 0;
                                // Board clean up
                                boardCleanup();
                            });
                        } else if (currentPlayer == 4) {
                            circleRed[setMove].setFill(Color.BLACK);
                            // Set the click action event
                            buttonRed[setMove].setOnAction(e -> {
                                buttonRed[setMove].setStyle(
                                        "-fx-background-radius: 5em; " +
                                                "-fx-min-width: 30px; " +
                                                "-fx-min-height: 30px; " +
                                                "-fx-max-width: 30px; " +
                                                "-fx-max-height: 30px;" +
                                                "-fx-background-color: Red");
                                // Remove the illumination to show the move has been made
                                circleRed[setMove].setFill(Color.WHITE);
                                // Update the player position in playerHomes array to show that it's occupied
                                playerHomes[currentPlayer][setMove] = 1;
                                // Change the color of the button the player piece left
                                buttonRed[setOriginal].setStyle(
                                        "-fx-background-radius: 5em; " +
                                                "-fx-min-width: 30px; " +
                                                "-fx-min-height: 30px; " +
                                                "-fx-max-width: 30px; " +
                                                "-fx-max-height: 30px;"
                                );
                                // Set the current player position in the board array to empty
                                playerHomes[currentPlayer][setOriginal] = 0;
                                // Board clean up
                                boardCleanup();
                            });
                        } else if (currentPlayer == 5) {
                            circleOrange[setMove].setFill(Color.BLACK);
                            // Set the click action event
                            buttonOrange[setMove].setOnAction(e -> {
                                buttonOrange[setMove].setStyle(
                                        "-fx-background-radius: 5em; " +
                                                "-fx-min-width: 30px; " +
                                                "-fx-min-height: 30px; " +
                                                "-fx-max-width: 30px; " +
                                                "-fx-max-height: 30px;" +
                                                "-fx-background-color: Orange");
                                // Remove the illumination to show the move has been made
                                circleOrange[setMove].setFill(Color.WHITE);
                                // Update the player position in playerHomes array to show that it's occupied
                                playerHomes[currentPlayer][setMove] = 1;
                                // Change the color of the button the player piece left
                                buttonOrange[setOriginal].setStyle(
                                        "-fx-background-radius: 5em; " +
                                                "-fx-min-width: 30px; " +
                                                "-fx-min-height: 30px; " +
                                                "-fx-max-width: 30px; " +
                                                "-fx-max-height: 30px;"
                                );
                                // Set the current player position in the board array to empty
                                playerHomes[currentPlayer][setOriginal] = 0;
                                // Board clean up
                                boardCleanup();
                            });
                        }
                    }
                }
            }
        }
    }

    public void endTurn() {
        boolean gameContinue = true;
        // Victory Screen
        for (int i = 0; i < 4; i++) {
            if (playerHomes[currentPlayer][i] == 0) {
                break;
            } else if (i == 3) {
                VictoryBox.display(playerColors[currentPlayer] + " has won the game! Congratulations!");
                nextTurn.setDisable(true);
                boardCleanup();
                gameContinue = false;
            }
        }
        if (gameContinue) {
            // If the player rolls a 6, they get another turn
            if (dice == 6) {
                currentPlayer -= 1;
            }
            // After player 6's turn, loop back to player 1
            currentPlayer++;
            if (currentPlayer > 5) {
                currentPlayer = 0;
                // Increase the turn counter
                currentTurn++;
            }
            // Call the turn method to start the next turn if it is a human
            turn();
        }
    }

    public void newGame() {
        boardCleanup();
        for (int i = 0; i < 4; i++) {
            // Reset the player homes
            buttonYellow[i].setStyle(
                    "-fx-background-radius: 5em; " +
                            "-fx-min-width: 30px; " +
                            "-fx-min-height: 30px; " +
                            "-fx-max-width: 30px; " +
                            "-fx-max-height: 30px;");
            buttonGreen[i].setStyle(
                    "-fx-background-radius: 5em; " +
                            "-fx-min-width: 30px; " +
                            "-fx-min-height: 30px; " +
                            "-fx-max-width: 30px; " +
                            "-fx-max-height: 30px;");
            buttonMagenta[i].setStyle(
                    "-fx-background-radius: 5em; " +
                            "-fx-min-width: 30px; " +
                            "-fx-min-height: 30px; " +
                            "-fx-max-width: 30px; " +
                            "-fx-max-height: 30px;");
            buttonBlue[i].setStyle(
                    "-fx-background-radius: 5em; " +
                            "-fx-min-width: 30px; " +
                            "-fx-min-height: 30px; " +
                            "-fx-max-width: 30px; " +
                            "-fx-max-height: 30px;");
            buttonRed[i].setStyle(
                    "-fx-background-radius: 5em; " +
                            "-fx-min-width: 30px; " +
                            "-fx-min-height: 30px; " +
                            "-fx-max-width: 30px; " +
                            "-fx-max-height: 30px;");
            buttonOrange[i].setStyle(
                    "-fx-background-radius: 5em; " +
                            "-fx-min-width: 30px; " +
                            "-fx-min-height: 30px; " +
                            "-fx-max-width: 30px; " +
                            "-fx-max-height: 30px;");
        }
        for (int j = 0; j < 6; j++) {
            // Reset the amount in the player bases
            playerBases[j] = 3;
            // Reset the player home rows
            for (int k = 0; k < 4; k++) {
                playerHomes[j][k] = 0;
            }
        }
        // Reset the center
        buttonCenter.setStyle(
                "-fx-background-radius: 5em; " +
                        "-fx-min-width: 30px; " +
                        "-fx-min-height: 30px; " +
                        "-fx-max-width: 30px; " +
                        "-fx-max-height: 30px;");
        centerPlayer = 6;
        centerSpot = false;
        // Reset the board
        for (int i = 0; i <= 83; i++) {
            board[i] = 6;
            buttonMain[i].setStyle(
                    "-fx-background-radius: 5em; " +
                            "-fx-min-width: 30px; " +
                            "-fx-min-height: 30px; " +
                            "-fx-max-width: 30px; " +
                            "-fx-max-height: 30px;");
        }
        currentPlayer = 0;
        currentTurn = 0;
        nextTurn.setDisable(false);
        devTest = false;
        base();
        turn();
    }

    public void boardCleanup() {
        // Reset the game board's illuminations and remove all click events
        for (int i = 0; i < 84; i++) {
            circleMain[i].setFill(Color.WHITE);
            buttonMain[i].setOnAction(null);
        }
        // Clear the center circle
        circleCenterMain.setFill(Color.WHITE);
        buttonCenter.setOnAction(null);
        for (int j = 0; j < 4; j++) {
            circleYellow[j].setFill(Color.WHITE);
            buttonYellow[j].setOnAction(null);
            circleGreen[j].setFill(Color.WHITE);
            buttonGreen[j].setOnAction(null);
            circleMagenta[j].setFill(Color.WHITE);
            buttonMagenta[j].setOnAction(null);
            circleBlue[j].setFill(Color.WHITE);
            buttonBlue[j].setOnAction(null);
            circleRed[j].setFill(Color.WHITE);
            buttonRed[j].setOnAction(null);
            circleOrange[j].setFill(Color.WHITE);
            buttonOrange[j].setOnAction(null);
        }
        // Reset difference
        difference = 0;
        differenceHome = 0;
        // Enable the next turn button
        nextTurn.setDisable(false);
        devTest = false;
    }

    public void base() {
        // This function goes through to update all of the player bases
        for (int i = 0; i < 4; i++) {
            if (i <= playerBases[0]) {
                buttonYellowBase[i].setStyle(
                        "-fx-background-radius: 5em; " +
                                "-fx-min-width: 30px; " +
                                "-fx-min-height: 30px; " +
                                "-fx-max-width: 30px; " +
                                "-fx-max-height: 30px;");
            } else {
                buttonYellowBase[i].setStyle(
                        "-fx-background-radius: 5em; " +
                                "-fx-min-width: 30px; " +
                                "-fx-min-height: 30px; " +
                                "-fx-max-width: 30px; " +
                                "-fx-max-height: 30px;" +
                                "-fx-background-color: Yellow");
            }
            if (i <= playerBases[1]) {
                buttonGreenBase[i].setStyle(
                        "-fx-background-radius: 5em; " +
                                "-fx-min-width: 30px; " +
                                "-fx-min-height: 30px; " +
                                "-fx-max-width: 30px; " +
                                "-fx-max-height: 30px;");
            } else {
                buttonGreenBase[i].setStyle(
                        "-fx-background-radius: 5em; " +
                                "-fx-min-width: 30px; " +
                                "-fx-min-height: 30px; " +
                                "-fx-max-width: 30px; " +
                                "-fx-max-height: 30px;" +
                                "-fx-background-color: Green");
            }
            if (i <= playerBases[2]) {
                buttonMagentaBase[i].setStyle(
                        "-fx-background-radius: 5em; " +
                                "-fx-min-width: 30px; " +
                                "-fx-min-height: 30px; " +
                                "-fx-max-width: 30px; " +
                                "-fx-max-height: 30px;");
            } else {
                buttonMagentaBase[i].setStyle(
                        "-fx-background-radius: 5em; " +
                                "-fx-min-width: 30px; " +
                                "-fx-min-height: 30px; " +
                                "-fx-max-width: 30px; " +
                                "-fx-max-height: 30px;" +
                                "-fx-background-color: Magenta");
            }
            if (i <= playerBases[3]) {
                buttonBlueBase[i].setStyle(
                        "-fx-background-radius: 5em; " +
                                "-fx-min-width: 30px; " +
                                "-fx-min-height: 30px; " +
                                "-fx-max-width: 30px; " +
                                "-fx-max-height: 30px;");
            } else {
                buttonBlueBase[i].setStyle(
                        "-fx-background-radius: 5em; " +
                                "-fx-min-width: 30px; " +
                                "-fx-min-height: 30px; " +
                                "-fx-max-width: 30px; " +
                                "-fx-max-height: 30px;" +
                                "-fx-background-color: Navy");
            }
            if (i <= playerBases[4]) {
                buttonRedBase[i].setStyle(
                        "-fx-background-radius: 5em; " +
                                "-fx-min-width: 30px; " +
                                "-fx-min-height: 30px; " +
                                "-fx-max-width: 30px; " +
                                "-fx-max-height: 30px;");
            } else {
                buttonRedBase[i].setStyle(
                        "-fx-background-radius: 5em; " +
                                "-fx-min-width: 30px; " +
                                "-fx-min-height: 30px; " +
                                "-fx-max-width: 30px; " +
                                "-fx-max-height: 30px;" +
                                "-fx-background-color: Red");
            }
            if (i <= playerBases[5]) {
                buttonOrangeBase[i].setStyle(
                        "-fx-background-radius: 5em; " +
                                "-fx-min-width: 30px; " +
                                "-fx-min-height: 30px; " +
                                "-fx-max-width: 30px; " +
                                "-fx-max-height: 30px;");
            } else {
                buttonOrangeBase[i].setStyle(
                        "-fx-background-radius: 5em; " +
                                "-fx-min-width: 30px; " +
                                "-fx-min-height: 30px; " +
                                "-fx-max-width: 30px; " +
                                "-fx-max-height: 30px;" +
                                "-fx-background-color: Orange");
            }
        }
    }

    public void normalMove(int position, int positionPotential) {
        // Change the color of the button the player piece is moving to
        buttonMain[positionPotential].setStyle(
                "-fx-background-radius: 5em; " +
                        "-fx-min-width: 30px; " +
                        "-fx-min-height: 30px; " +
                        "-fx-max-width: 30px; " +
                        "-fx-max-height: 30px;" +
                        "-fx-background-color: " + playerColors[currentPlayer]);
        // Change the color of the button the player piece left
        buttonMain[position].setStyle(
                "-fx-background-radius: 5em; " +
                        "-fx-min-width: 30px; " +
                        "-fx-min-height: 30px; " +
                        "-fx-max-width: 30px; " +
                        "-fx-max-height: 30px;");
        // Set the current player position in the board array to 6 (empty)
        board[position] = 6;
        // Update the position on the board array with the current player
        board[positionPotential] = currentPlayer;
        // Board cleanup
        boardCleanup();
    }

    public void landOnOpponent(int position, int positionPotential) {
        // Change the color of the button the player piece is moving to
        buttonMain[positionPotential].setStyle(
                "-fx-background-radius: 5em; " +
                        "-fx-min-width: 30px; " +
                        "-fx-min-height: 30px; " +
                        "-fx-max-width: 30px; " +
                        "-fx-max-height: 30px;" +
                        "-fx-background-color: " + playerColors[currentPlayer]);
        // Change the color of the button the player piece left
        buttonMain[position].setStyle(
                "-fx-background-radius: 5em; " +
                        "-fx-min-width: 30px; " +
                        "-fx-min-height: 30px; " +
                        "-fx-max-width: 30px; " +
                        "-fx-max-height: 30px;");
        // Adds one to the player base (this number is how many pieces are in the player base)
        playerBases[opponentPiece] += 1;
        // Remove the illumination to show the move has been made
        circleMain[positionPotential].setFill(Color.WHITE);
        // Set the previous player position in the board array to 6 (empty)
        board[position] = 6;
        // Update the position on the board array with the current player
        board[positionPotential] = currentPlayer;
        // Refreshes the player bases
        base();
        // Board cleanup
        boardCleanup();
    }

    public void homeRow () {
        // This goes through and refreshes the home rows for each player, updating the buttons to reflect which pieces are in which spots
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if ((i == 0) && (playerHomes[i][j] == 0)) {
                    buttonYellow[j].setStyle(
                            "-fx-background-radius: 5em; " +
                                    "-fx-min-width: 30px; " +
                                    "-fx-min-height: 30px; " +
                                    "-fx-max-width: 30px; " +
                                    "-fx-max-height: 30px;");
                } else if ((i == 0) && (playerHomes[i][j] == 1)) {
                    buttonYellow[j].setStyle(
                            "-fx-background-radius: 5em; " +
                                    "-fx-min-width: 30px; " +
                                    "-fx-min-height: 30px; " +
                                    "-fx-max-width: 30px; " +
                                    "-fx-max-height: 30px;" +
                                    "-fx-background-color: Yellow");
                } else if ((i == 1) && (playerHomes[i][j] == 0)) {
                    buttonGreen[j].setStyle(
                            "-fx-background-radius: 5em; " +
                                    "-fx-min-width: 30px; " +
                                    "-fx-min-height: 30px; " +
                                    "-fx-max-width: 30px; " +
                                    "-fx-max-height: 30px;");
                } else if ((i == 1) && (playerHomes[i][j] == 1)) {
                    buttonGreen[j].setStyle(
                            "-fx-background-radius: 5em; " +
                                    "-fx-min-width: 30px; " +
                                    "-fx-min-height: 30px; " +
                                    "-fx-max-width: 30px; " +
                                    "-fx-max-height: 30px;" +
                                    "-fx-background-color: Green");
                } else if ((i == 2) && (playerHomes[i][j] == 0)) {
                    buttonMagenta[j].setStyle(
                            "-fx-background-radius: 5em; " +
                                    "-fx-min-width: 30px; " +
                                    "-fx-min-height: 30px; " +
                                    "-fx-max-width: 30px; " +
                                    "-fx-max-height: 30px;");
                } else if ((i == 2) && (playerHomes[i][j] == 1)) {
                    buttonMagenta[j].setStyle(
                            "-fx-background-radius: 5em; " +
                                    "-fx-min-width: 30px; " +
                                    "-fx-min-height: 30px; " +
                                    "-fx-max-width: 30px; " +
                                    "-fx-max-height: 30px;" +
                                    "-fx-background-color: Magenta");
                } else if ((i == 3) && (playerHomes[i][j] == 0)) {
                    buttonBlue[j].setStyle(
                            "-fx-background-radius: 5em; " +
                                    "-fx-min-width: 30px; " +
                                    "-fx-min-height: 30px; " +
                                    "-fx-max-width: 30px; " +
                                    "-fx-max-height: 30px;");
                } else if ((i == 3) && (playerHomes[i][j] == 1)) {
                    buttonBlue[j].setStyle(
                            "-fx-background-radius: 5em; " +
                                    "-fx-min-width: 30px; " +
                                    "-fx-min-height: 30px; " +
                                    "-fx-max-width: 30px; " +
                                    "-fx-max-height: 30px;" +
                                    "-fx-background-color: Navy");
                } else if ((i == 4) && (playerHomes[i][j] == 0)) {
                    buttonRed[j].setStyle(
                            "-fx-background-radius: 5em; " +
                                    "-fx-min-width: 30px; " +
                                    "-fx-min-height: 30px; " +
                                    "-fx-max-width: 30px; " +
                                    "-fx-max-height: 30px;");
                } else if ((i == 4) && (playerHomes[i][j] == 1)) {
                    buttonRed[j].setStyle(
                            "-fx-background-radius: 5em; " +
                                    "-fx-min-width: 30px; " +
                                    "-fx-min-height: 30px; " +
                                    "-fx-max-width: 30px; " +
                                    "-fx-max-height: 30px;" +
                                    "-fx-background-color: Red");
                } else if ((i == 5) && (playerHomes[i][j] == 0)) {
                    buttonOrange[j].setStyle(
                            "-fx-background-radius: 5em; " +
                                    "-fx-min-width: 30px; " +
                                    "-fx-min-height: 30px; " +
                                    "-fx-max-width: 30px; " +
                                    "-fx-max-height: 30px;");
                } else if ((i == 5) && (playerHomes[i][j] == 1)) {
                    buttonOrange[j].setStyle(
                            "-fx-background-radius: 5em; " +
                                    "-fx-min-width: 30px; " +
                                    "-fx-min-height: 30px; " +
                                    "-fx-max-width: 30px; " +
                                    "-fx-max-height: 30px;" +
                                    "-fx-background-color: Orange");
                }
            }
        }
    }
}

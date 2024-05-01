// Erhowvosere Otubu
// 20293052
// 2023-04-10

package com.example.guessmaster;


import android.view.View;
import android.widget.*;
import java.util.Random;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class GuessMaster extends AppCompatActivity {

    private TextView entityName;
    private TextView ticketSum;
    private Button guessButton;
    private EditText userInput;
    private Button clearButtonContent;
    private ImageView entityImage;
    String answer;
    private int numOfEntities;
    private Entity[] entities;
    private int totalNumOfTickets;
    private Entity ent;

    Politician jTrudeau = new Politician("Justin Trudeau",
            new Date("December", 25, 1971),
            "Male", "Liberal", 0.25);
    Person myCreator = new Person("My Creator (Sere Otubu)",
            new Date("February", 16, 2003), "Male", 1);
    Country usa = new Country("United States",
            new Date("July", 4, 1776), "Washington D.C.", 0.1);
    Singer cDion = new Singer("Celine Dion",
            new Date("March", 30, 1968),
            "Female", "Le Voix Du Bon Dieu",
            new Date("November", 6, 1981), 0.5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_master);
        guessButton = (Button) findViewById(R.id.btnguess);
        clearButtonContent = (Button) findViewById(R.id.btnclear);
        userInput = (EditText) findViewById(R.id.guessinput);
        ticketSum = (TextView) findViewById(R.id.ticket);
        entityName = (TextView) findViewById(R.id.entityname);
        entityImage = (ImageView) findViewById(R.id.entityimage);

        new GuessMaster();

        addEntity(jTrudeau);
        addEntity(cDion);
        addEntity(myCreator);
        addEntity(usa);

        changeEntity();
        welcomeToGame(ent);


        clearButtonContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeEntity();
            }
        });

        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame(ent);
            }
        });
    }

    public GuessMaster() {
        numOfEntities = 0;
        entities = new Entity[100];
        totalNumOfTickets = 0;
    }

    public void addEntity(Politician politician) { // adds politician to the entity array
        entities[numOfEntities++] = new Politician(politician);
    }

    public void addEntity(Singer singer) { // adds singer to the entity array
        entities[numOfEntities++] = new Singer(singer);
    }

    public void addEntity(Person person) { // adds 'person' to the entity array
        entities[numOfEntities++] = new Person(person);
    }

    public void addEntity(Country country) { // // adds country to the entity array
        entities[numOfEntities++] = new Country(country);
    }

    public void playGame(Entity entity) {
        answer = userInput.getText().toString();
        answer = answer.replace("\n", "").replace("\r", "");
        Date date = new Date(answer);

        if (date.precedes(entity.getBorn())) {
            AlertDialog.Builder laterAlert = new AlertDialog.Builder(GuessMaster.this);
            laterAlert.setIcon(R.drawable.ic_error_outline_black_24dp);
            laterAlert.setTitle("Incorrect");
            laterAlert.setMessage("Try a later date than " +date.toString());
            laterAlert.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //Toast.makeText(getBaseContext(), "Game is Starting...", Toast.LENGTH_SHORT).show();
                }
            });
            laterAlert.show();

        }
        else if (entity.getBorn().precedes(date)) {
            AlertDialog.Builder earlyAlert = new AlertDialog.Builder(GuessMaster.this);
            earlyAlert.setIcon(R.drawable.ic_error_outline_black_24dp);
            earlyAlert.setTitle("Incorrect");
            earlyAlert.setMessage("Try an earlier date than " +date.toString());
            earlyAlert.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //Toast.makeText(getBaseContext(), "Game is Starting...", Toast.LENGTH_SHORT).show();
                }
            });
            earlyAlert.show();

        }
        else {
            int ticketsWon = (int) ((entity.getDifficulty()) * 100);
            totalNumOfTickets += ticketsWon;
            AlertDialog.Builder correctalert = new AlertDialog.Builder(GuessMaster.this);
            correctalert.setIcon(R.drawable.ic_check_circle_black_24dp);
            correctalert.setTitle("You Won!");
            correctalert.setMessage("Bingo! Congrats! The correct information is: \n" +entity.toString());
            correctalert.setNegativeButton("Continue", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ContinueGame();
                }
            });
            correctalert.show();
            ticketSum.setText("Total Tickets: " + totalNumOfTickets);
        }

    }

    public int genRandomEntityId() {
        Random randomNumber = new Random();
        return randomNumber.nextInt(numOfEntities);
    }

    public void changeEntity() {
        int entityID = genRandomEntityId();
        Entity entity = entities[entityID];

        // Set the text of the entityName TextView to the name of the entity
        entityName.setText(entity.getName());

        //Set the image resource of the entityImage ImageView to the image associated with the entity
        ImageSetter(entity);

        ent = entity;
    }

    public void ImageSetter(Entity entity) {
        if (entity.toString().equals(jTrudeau.toString())){
            /*
            If the entity is jTrudeau, it sets the image of the
            entity to a photo of a Justin Trudeau image
             */
            entityImage.setImageResource(R.drawable.justtru);
        }
        else if (entity.toString().equals(usa.toString())){
            /*
            If the entity is usa, it sets the image of the
            entity to a photo of a USA image
             */
            entityImage.setImageResource(R.drawable.usaflag);
        }
        else if (entity.toString().equals(myCreator.toString())){
            /*
            If the entity is myCreator, it sets the image of the
            entity to a photo of a the creator of the game
             */
            entityImage.setImageResource(R.drawable.mycreator);
        }
        else if (entity.toString().equals(cDion.toString())){
            /*
            If the entity is cDion, it sets the image of the
            entity to a photo of a Celine Dion image
             */
            entityImage.setImageResource(R.drawable.celidion);
        }
    }

    public void ContinueGame() {
        // Clears any text currently entered in the guess field on the android screen
        userInput.getText().clear();
        // Calls the changeEntity() method to change to the next entity to be guessed
        changeEntity();
    }

    public void welcomeToGame(Entity entity) {
        AlertDialog.Builder welcomeAlert = new AlertDialog.Builder(GuessMaster.this);

        // Sets the title of the dialog box to "GuessMaster Game"
        welcomeAlert.setTitle("GuessMaster Game");
        welcomeAlert.setMessage(entity.welcomeMessage());

        // Prevents the user from dismissing the dialog box by clicking outside of it
        welcomeAlert.setCancelable(false);
        welcomeAlert.setNegativeButton("START GAME", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                /*
                When the button is clicked, the screen displays a short
                message with the text "Game is loading..."
                 */
                Toast.makeText(getBaseContext(), "Game is loading...", Toast.LENGTH_SHORT).show();
            }
        });
        welcomeAlert.show();
    }
}

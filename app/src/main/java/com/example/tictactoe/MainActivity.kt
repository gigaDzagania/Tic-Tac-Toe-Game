package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var wonXO = ""
    private var player = "p1"
    private var ptX = 0
    private var ptO = 0

    private lateinit var turnText: TextView
    private lateinit var pointX: TextView
    private lateinit var pointO: TextView
    private lateinit var textResult: TextView
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var resetButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pointX = findViewById(R.id.pointX)
        pointO = findViewById(R.id.pointO)
        turnText = findViewById(R.id.turnText)
        textResult = findViewById(R.id.textResult)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        resetButton = findViewById(R.id.resetButton)

        button1.setOnClickListener{
            buttonClick(button1)
            setTurnLabel(turnText)
        }

        button2.setOnClickListener{
            buttonClick(button2)
            setTurnLabel(turnText)
        }

        button3.setOnClickListener{
            buttonClick(button3)
            setTurnLabel(turnText)
        }

        button4.setOnClickListener{
            buttonClick(button4)
            setTurnLabel(turnText)
        }

        button5.setOnClickListener{
            buttonClick(button5)
            setTurnLabel(turnText)
        }

        button6.setOnClickListener{
            buttonClick(button6)
            setTurnLabel(turnText)
        }

        button7.setOnClickListener{
            buttonClick(button7)
            setTurnLabel(turnText)
        }

        button8.setOnClickListener{
            buttonClick(button8)
            setTurnLabel(turnText)
        }

        button9.setOnClickListener{
            buttonClick(button9)
            setTurnLabel(turnText)
        }

        resetButton.setOnClickListener{
            reset()
        }
    }

/* ფუნქცია შექმნილია იმისთვის რომ ღილაკებში ინფორმაცია( X ან O ) მათში მონაცვლეობით ჩაიწეროს  */
    private fun buttonClick(btn: Button){
        if (btn.text == ""){
            if (player == "p1"){
                player = "p2"
                btn.text = "X"
            }else {
                player = "p1"
                btn.text = "O"
            }
        }
        winningPlayer()
    }

/* ფუნქცია შექმნილია იმისთვის რომ განსაზღვროს მოიგო თუ არა რომელიმე მოთამშემ ( X ან O ) */
    private fun winningPlayer() {

        if (   (button1.text == "X" && button2.text == "X" && button3.text == "X")
            || (button4.text == "X" && button5.text == "X" && button6.text == "X")
            || (button7.text == "X" && button8.text == "X" && button9.text == "X")
            || (button1.text == "X" && button5.text == "X" && button9.text == "X")
            || (button3.text == "X" && button5.text == "X" && button7.text == "X")
            || (button1.text == "X" && button4.text == "X" && button7.text == "X")
            || (button2.text == "X" && button5.text == "X" && button8.text == "X")
            || (button3.text == "X" && button6.text == "X" && button9.text == "X")) {
                wonXO = "X"
                Toast.makeText(this,"X  points +1", Toast.LENGTH_SHORT).show()
                disableButtons()
        }
        else if (
               (button1.text == "O" && button2.text == "O" && button3.text == "O")
            || (button4.text == "O" && button5.text == "O" && button6.text == "O")
            || (button7.text == "O" && button8.text == "O" && button9.text == "O")
            || (button1.text == "O" && button5.text == "O" && button9.text == "O")
            || (button3.text == "O" && button5.text == "O" && button7.text == "O")
            || (button1.text == "O" && button4.text == "O" && button7.text == "O")
            || (button2.text == "O" && button5.text == "O" && button8.text == "O")
            || (button3.text == "O" && button6.text == "O" && button9.text == "O")) {
                wonXO = "O"
                Toast.makeText(this,"O  points +1", Toast.LENGTH_SHORT).show()
                disableButtons()
        }
        else{
            if (   button1.text != "" && button2.text != "" && button3.text != ""
                && button4.text != "" && button5.text != "" && button6.text != ""
                && button7.text != "" && button8.text != "" && button9.text != ""){
                    wonXO = "0:0"
                    Toast.makeText(this,"Match Draw/Tie", Toast.LENGTH_SHORT).show()
            }
        }

    result()
    buttonCleaning()
    gameEnd()

    }


/* ფუნქცია შექმნილია RESET ღილაკისთვის რომ მასზე დაწოლის შედეგად თამაში დაიწყოს
*  სრულიად ახლი ანუ გაქრესე ქულები და წაიშალოს X და O */
    private fun reset() {

        button1.text = ""
        button2.text = ""
        button3.text = ""
        button4.text = ""
        button5.text = ""
        button6.text = ""
        button7.text = ""
        button8.text = ""
        button9.text = ""
        textResult.text = ""
        turnText.text = "Turn X"
        pointX.text = "0"
        pointO.text = "0"
        ptX = 0
        ptO = 0

        button1.isEnabled = true
        button2.isEnabled = true
        button3.isEnabled = true
        button4.isEnabled = true
        button5.isEnabled = true
        button6.isEnabled = true
        button7.isEnabled = true
        button8.isEnabled = true
        button9.isEnabled = true

        this.player = "p1"
    }


/* თუნქცია შექმნილია იმისთვის რომ თუ რომელიმე მოთამაშემ მოიგო თამაში და ღილაკები ცარიელია
*  მოთამაშეებს არ შეეძლოთ სხვა ღილაკზე ზემოქმედება (მართალია მოგების შემდეგ buttonCleaning ფუნქციით
*  თამაშში ისედაც ქრება ღილაკებში არსებული ინფორმაცია(x და o) და მხოლოდ ქულები რჩება, მაგრამ მაინც */
    private fun disableButtons() {

        button1.isEnabled = false
        button2.isEnabled = false
        button3.isEnabled = false
        button4.isEnabled = false
        button5.isEnabled = false
        button6.isEnabled = false
        button7.isEnabled = false
        button8.isEnabled = false
        button9.isEnabled = false
    }


/* ფუნქცია შექმნილია იმისთვის რომ მოთამაშეებს მიუთითოს ( X ჯერია თუ O )  */
    private fun setTurnLabel(turn: TextView) {

        if (player == "p1") {
            turn.text = "Turn  X"
        }
        else {
            turn.text = "Turn  O"
        }
    }


/* ფუნქცია შექმნილია იმისთვის რომ რომელიმე მოთამაშის მოგების შემთხვევაში აისახოს შესაბამისი ქულა */
    private fun result() {

        if (wonXO == "X") {
            ptX++
            pointX.text = ptX.toString()
        }
        else if (wonXO == "O") {
            ptO++
            pointO.text = ptO.toString()
        }
    }


/* ფუნქცია შექმნილია იმისთვის რომ თუ რომელიმე მოთამაშემ მოიგო ღილაკებში არსებული ინფორმაცია
*  უმალვე წაიშლება */
    private fun buttonCleaning(){
        if ((wonXO == "X") || (wonXO == "O") || (wonXO == "0:0")){

            button1.text = ""
            button2.text = ""
            button3.text = ""
            button4.text = ""
            button5.text = ""
            button6.text = ""
            button7.text = ""
            button8.text = ""
            button9.text = ""
            turnText.text = "Turn X"
            wonXO = ""

            button1.isEnabled = true
            button2.isEnabled = true
            button3.isEnabled = true
            button4.isEnabled = true
            button5.isEnabled = true
            button6.isEnabled = true
            button7.isEnabled = true
            button8.isEnabled = true
            button9.isEnabled = true

            this.player = "p1"

        }
    }


/* ფუნქცია შექმნილია იმისთვის , რომ თუ რომელიმე მოთმამაშე მოაგროვებს 3 ქულას თამაში შეწყდეს და
* გამოჩნდეს სესაბამისი წარწერა(Won the gama) . თამაშის ხელახლა დასაწყებად საჭირო გახდბა RESET ღილაკი  */
    private fun gameEnd(){

        if (ptX == 3){
            textResult.text = "X  won the game"
            buttonCleaning()
            disableButtons()

        }
        else if (ptO ==3){
            textResult.text = "O  won the game"
            buttonCleaning()
            disableButtons()
        }
    }

}
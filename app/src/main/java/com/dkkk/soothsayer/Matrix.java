package com.dkkk.soothsayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Matrix extends AppCompatActivity {

    private EditText vvod;
    private Button knopka;
    private ImageButton reset;
    private TextView result;
    private ImageView matrixImage;
    private TextView zonaTalent;
    private TextView zonaPortret;
    private TextView zonaMat;
    private TextView zonaKarma;
    private TextView centralArcan;
    private TextView zonaM1;
    private TextView zonaM2;
    private TextView zonaG1;
    private TextView zonaG2;
    private TextView Talant1;
    private TextView Talant2;
    private TextView Portret1;
    private TextView Portret2;
    private TextView Mat1;
    private TextView Mat2;
    private TextView Karma1;
    private TextView Karma2;

    private final String[] textArray = {
            "Состояние человека «в плюсе»:\n" +
                    "\n" +
                    "Движение. Подобно Колеснице этот человек уверенно движется вперёд, умело преодолевая все преграды на пути. Он любит скорость и динамичное развитие событий, любое промедление, а тем более остановка для него неприемлемы. \n" +
            "Состояние человека «в минусе»:\n" +
                    "\n" +
                    "Застой. Если жизнь заставляет такого человека остановиться, ему очень сложно вновь начать движение вперёд. Поэтому любые достаточно серьёзные препятствия на пути Колесницы — могут стать фатальными. В некоторых случаях неудачи бывают случайными, а обстоятельства приведшие к остановке мелкими и несущественными.\n" +
            "Состояние человека «в плюсе»:\n" +
                    "\n" +
                    "Проницательность. Такой человек очень проницателен, быстро понимает истинные причины происходящего, хорошо чувствует мотивы и предвидит события. Хочет разобраться в мельчайших подробностях, всегда и всё любит «раскладывать по полочкам», и это обычно ему удаётся. \n" +
            "Состояние человека «в минусе»:\n" +
                    "\n" +
                    "Отстранённость и эгоизм. В минусе это может быть закрытый, замкнутый или погружённый в себя человек. Больше всего он думает о себе, а значит, ему сложно строить построить здоровые отношения. Втайне может гордиться своей принципиальностью и считать окружающих недостойными себя.\n" +
            "Состояние человека «в плюсе»:\n" +
                    "\n" +
                    "Амбиции. Это очень решительный и амбициозный человек, он не привык размениваться на мелочи, ставит перед собой глобальные цели и верит в их достижение. Крайне требователен к себе и подчинённым, быстро двигается по карьерной лестнице. Может завести бизнес и успешно развить своё дело до высокого уровня.\n" +
            "Состояние человека «в минусе»:\n" +
                    "\n" +
                    "Высокомерие. Добившись некоторых результатов, такой человек становится высокомерным гордецом. При любой возможности превозносит собственные заслуги, кичится общественным положением или материальным достатком. Может незаслуженно оскорблять подчинённых и друзей, ставя себя выше остальных."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_matrix);

        vvod = findViewById(R.id.vvod);
        knopka = findViewById(R.id.knopka);
        reset = findViewById(R.id.reset);
        result = findViewById(R.id.result);
        matrixImage = findViewById(R.id.matrixImage);
        zonaTalent = findViewById(R.id.zonaTalant);
        zonaPortret = findViewById(R.id.zonaPortret);
        zonaMat = findViewById(R.id.zonaMat);
        zonaKarma = findViewById(R.id.zonaKarma);
        centralArcan = findViewById(R.id.centralArcan);
        zonaM1 = findViewById(R.id.zonaM1);
        zonaM2 = findViewById(R.id.zonaM2);
        zonaG1 = findViewById(R.id.zonaG1);
        zonaG2 = findViewById(R.id.zonaG2);
        Talant1 = findViewById(R.id.Talant1);
        Talant2 = findViewById(R.id.Talant2);
        Portret1 = findViewById(R.id.Portret1);
        Portret2 = findViewById(R.id.Portret2);
        Mat1 = findViewById(R.id.Mat1);
        Mat2 = findViewById(R.id.Mat2);
        Karma1 = findViewById(R.id.Karma1);
        Karma2 = findViewById(R.id.Karma2);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vvod.setVisibility(View.VISIBLE);
                knopka.setVisibility(View.VISIBLE);
                matrixImage.setVisibility(View.GONE);
                result.setVisibility(View.GONE);
                zonaTalent.setVisibility(View.GONE);
                zonaPortret.setVisibility(View.GONE);
                zonaMat.setVisibility(View.GONE);
                zonaKarma.setVisibility(View.GONE);
                centralArcan.setVisibility(View.GONE);
                zonaM1.setVisibility(View.GONE);
                zonaM2.setVisibility(View.GONE);
                zonaG1.setVisibility(View.GONE);
                zonaG2.setVisibility(View.GONE);
                Talant1.setVisibility(View.GONE);
                Talant2.setVisibility(View.GONE);
                Mat1.setVisibility(View.GONE);
                Mat2.setVisibility(View.GONE);
                Karma1.setVisibility(View.GONE);
                Karma2.setVisibility(View.GONE);
                Portret1.setVisibility(View.GONE);
                Portret2.setVisibility(View.GONE);
            }
        });

        knopka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = vvod.getText().toString();
                if (validateInput(input)) {
                    vvod.setVisibility(View.GONE);
                    knopka.setVisibility(View.GONE);
                    matrixImage.setVisibility(View.VISIBLE);
                    result.setVisibility(View.VISIBLE);
                    zonaTalent.setVisibility(View.VISIBLE);
                    zonaPortret.setVisibility(View.VISIBLE);
                    zonaMat.setVisibility(View.VISIBLE);
                    zonaKarma.setVisibility(View.VISIBLE);
                    centralArcan.setVisibility(View.VISIBLE);
                    zonaM1.setVisibility(View.VISIBLE);
                    zonaM2.setVisibility(View.VISIBLE);
                    zonaG1.setVisibility(View.VISIBLE);
                    zonaG2.setVisibility(View.VISIBLE);
                    Talant1.setVisibility(View.VISIBLE);
                    Talant2.setVisibility(View.VISIBLE);
                    Portret1.setVisibility(View.VISIBLE);
                    Portret2.setVisibility(View.VISIBLE);
                    Mat1.setVisibility(View.VISIBLE);
                    Mat2.setVisibility(View.VISIBLE);
                    Karma1.setVisibility(View.VISIBLE);
                    Karma2.setVisibility(View.VISIBLE);
                    Random random = new Random();
                    int randomIndex = random.nextInt(textArray.length);
                    String randomText = textArray[randomIndex];
                    result.setText(randomText);

                    extractFromInput(); // Вызов метода для извлечения месяца из ввода
                } else {
                    Toast.makeText(Matrix.this, "Введена неправильная дата", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void extractFromInput() {
        String input = vvod.getText().toString();
        String[] parts = input.split("\\.");

        if (parts.length >= 3) {
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);

            zonaTalent.setText(String.valueOf(month));

            int sumDay;
            if (day > 22) {
                sumDay = 0;
                while (day > 0) {
                    sumDay += day % 10;
                    day /= 10;
                }
                zonaPortret.setText(String.valueOf(sumDay));
            } else {
                sumDay = day;
                zonaPortret.setText(String.valueOf(day));
            }

            int sumYear = 0;
            for (int i = 0; i < parts[2].length(); i++) {
                sumYear += Character.getNumericValue(parts[2].charAt(i));
            }
            while (sumYear > 22) {
                int tempSum = 0;
                while (sumYear > 0) {
                    tempSum += sumYear % 10;
                    sumYear /= 10;
                }
                sumYear = tempSum;
            }
            zonaMat.setText(String.valueOf(sumYear));

            int totalSum = sumDay + month + sumYear;
            while (totalSum > 22) {
                int tempSum = 0;
                while (totalSum > 0) {
                    tempSum += totalSum % 10;
                    totalSum /= 10;
                }
                totalSum = tempSum;
            }
            zonaKarma.setText(String.valueOf(totalSum));

            int newSum = sumDay + month + sumYear + totalSum;
            if (newSum > 22) {
                int sumArcan = 0;
                while (newSum > 0) {
                    sumArcan += newSum % 10;
                    newSum /= 10;
                }
                newSum = sumArcan;
            }
                centralArcan.setText(String.valueOf(newSum));

            int sumM1 = sumDay + month;
            if (sumM1 > 22) {
                int sumArcan = 0;
                while (sumM1 > 0) {
                    sumArcan += sumM1 % 10;
                    sumM1 /= 10;
                }
                zonaM1.setText(String.valueOf(sumArcan));
            } else {
                zonaM1.setText(String.valueOf(sumM1));
            }

            int sumM2 = sumYear + totalSum;
            if (sumM2 > 22) {
                int sumArcan = 0;
                while (sumM2 > 0) {
                    sumArcan += sumM2 % 10;
                    sumM2 /= 10;
                }
                zonaM2.setText(String.valueOf(sumArcan));
            } else {
                zonaM2.setText(String.valueOf(sumM2));
            }

            int sumG1 = sumYear + month;
            if (sumG1 > 22) {
                int sumArcan = 0;
                while (sumG1 > 0) {
                    sumArcan += sumG1 % 10;
                    sumG1 /= 10;
                }
                zonaG1.setText(String.valueOf(sumArcan));
            } else {
                zonaG1.setText(String.valueOf(sumG1));
            }

            int sumG2 = sumDay + totalSum;
            if (sumG2 > 22) {
                int sumArcan = 0;
                while (sumG2 > 0) {
                    sumArcan += sumG2 % 10;
                    sumG2 /= 10;
                }
                zonaG2.setText(String.valueOf(sumArcan));
            } else {
                zonaG2.setText(String.valueOf(sumG2));
            }

            int sumTalant2 = month + newSum ;
            if (sumTalant2 > 22) {
                int sumArcan = 0;
                while (sumTalant2 > 0) {
                    sumArcan += sumTalant2 % 10;
                    sumTalant2 /= 10;
                }
                sumTalant2 = sumArcan;
                }
                Talant2.setText(String.valueOf(sumTalant2));

            int sumTalant1 = sumTalant2 + month;
            if (sumTalant1 > 22) {
                int sumArcan = 0;
                while (sumTalant1 > 0) {
                    sumArcan += sumTalant1 % 10;
                    sumTalant1 /= 10;
                }
                Talant1.setText(String.valueOf(sumArcan));
            } else {
                Talant1.setText(String.valueOf(sumTalant1));
            }

            int sumPortret2 = sumDay + newSum;
            if (sumPortret2 > 22) {
                int sumArcan = 0;
                while (sumPortret2 > 0) {
                    sumArcan += sumPortret2 % 10;
                    sumPortret2 /= 10;
                }
                sumPortret2 = sumArcan;
                }
                Portret2.setText(String.valueOf(sumPortret2));

            int sumPortret1 = sumDay + sumPortret2;
            if (sumPortret1 > 22) {
                int sumArcan = 0;
                while (sumPortret1 > 0) {
                    sumArcan += sumPortret1 % 10;
                    sumPortret1 /= 10;
                }
                Portret1.setText(String.valueOf(sumArcan));
            } else {
                Portret1.setText(String.valueOf(sumPortret1));
            }

            int sumMat2 = sumYear + newSum;
            if (sumMat2 > 22) {
                int sumArcan = 0;
                while (sumMat2 > 0) {
                    sumArcan += sumMat2 % 10;
                    sumMat2 /= 10;
                }
                sumMat2 = sumArcan;
                }
                Mat2.setText(String.valueOf(sumMat2));

            int sumMat1 = sumYear + sumMat2;
            if (sumMat1 > 22) {
                int sumArcan = 0;
                while (sumMat1 > 0) {
                    sumArcan += sumMat1 % 10;
                    sumMat1 /= 10;
                }
                Mat1.setText(String.valueOf(sumArcan));
            } else {
                Mat1.setText(String.valueOf(sumMat1));
            }

            int sumKarma2 = month + sumDay + sumYear + month + sumDay + sumYear + month + sumDay + sumYear;
            if (sumKarma2 > 22) {
                int sumArcan = 0;
                while (sumKarma2 > 0) {
                    sumArcan += sumKarma2 % 10;
                    sumKarma2 /= 10;
                }
                sumKarma2 = sumArcan;
            }
            Karma2.setText(String.valueOf(sumKarma2));

            int sumKarma1 = sumKarma2 + totalSum;
            if (sumKarma1 > 22) {
                int sumArcan = 0;
                while (sumKarma1 > 0) {
                    sumArcan += sumKarma1 % 10;
                    sumKarma1 /= 10;
                }
                Karma1.setText(String.valueOf(sumArcan));
            } else {
                Karma1.setText(String.valueOf(sumKarma1));
            }
        }
    }

    private boolean validateInput(String input) {
        String[] parts = input.split("\\.");

        if (parts.length != 3) {
            return false;
        }

        int day, month, year;
        try {
            day = Integer.parseInt(parts[0]);
            month = Integer.parseInt(parts[1]);
            year = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            return false; // Ошибка при преобразовании строки в число
        }

        if (day < 1 || day > 31 || month < 1 || month > 12 || year < 0 || year > 2024) {
            return false; // Некорректные значения дня, месяца или года
        }

        return true;
    }
    public void GoBack3(View v) {
        Intent intent = new Intent(this, Homeactivity.class);
        startActivity(intent);
    }
}
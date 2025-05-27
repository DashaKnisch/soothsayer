package com.dkkk.soothsayer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
import java.util.Map;

public class Test extends AppCompatActivity {

    private Button startButton;
    private ImageButton reset;
    private Button[] answerButtons;
    private TextView questionTextView;
    private ImageView resultImageView;
    private TextView resultTextView;
    private int currentQuestionIndex = 0;
    private int totalScore = 0;

    private Map<String, Integer> answerScores;

    private String[] questions = {
            "Вопрос 1: Какое время суток ты предпочитаешь?",
            "Вопрос 2: Какие магические атрибуты ты выберешь?",
            "Вопрос 3: Какое животное ты выберешь?",
            "Вопрос 4: Какую стихию ты выберешь?",
            "Вопрос 5: Какое оружие ты выберешь?",
            "Вопрос 6: Чего ты боишься?"
    };

    private String[][] answerOptions = {
            {"Утро", "День", "Вечер", "Полдень", "Заря", "Ночь"},
            {"Метла", "Зелья", "Магический шар", "Палочка", "Книга магии", "Карты Таро"},
            {"Сова", "Собака", "Рыбка", "Феникс", "Белый кот", "Чёрный ворон"},
            {"Воздух", "Земля", "Вода", "Огонь", "Магия света", "Магия тьмы"},
            {"Лук", "Щит", "Копьё", "Меч", "Книга", "Не нуждаюсь"},
            {"Высоты", "Заточения", "Предательства", "Одиночества", "Зла", "Ничего)"}
    };

    // Диапазоны очков для каждого результата

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_test);

        startButton = findViewById(R.id.startButton);
        reset = findViewById(R.id.reset);
        questionTextView = findViewById(R.id.questionTextView);
        resultImageView = findViewById(R.id.resultImageView);
        resultTextView = findViewById(R.id.resultTextView);

        // Инициализация списка ответов и соответствующих очков
        answerScores = new HashMap<>();

        answerScores.put("Утро", 1);
        answerScores.put("День", 2);
        answerScores.put("Вечер", 3);
        answerScores.put("Полдень", 4);
        answerScores.put("Заря", 5);
        answerScores.put("Ночь", 6);

        answerScores.put("Метла", 1);
        answerScores.put("Зелья", 2);
        answerScores.put("Магический шар", 3);
        answerScores.put("Палочка", 4);
        answerScores.put("Книга магии", 5);
        answerScores.put("Карты Таро", 6);

        answerScores.put("Сова", 1);
        answerScores.put("Собака", 2);
        answerScores.put("Рыбка", 3);
        answerScores.put("Феникс", 4);
        answerScores.put("Белый кот", 5);
        answerScores.put("Чёрный ворон", 6);

        answerScores.put("Воздух", 1);
        answerScores.put("Земля", 2);
        answerScores.put("Вода", 3);
        answerScores.put("Огонь", 4);
        answerScores.put("Магия света", 5);
        answerScores.put("Магия тьмы", 6);

        answerScores.put("Лук", 1);
        answerScores.put("Щит", 2);
        answerScores.put("Копьё", 3);
        answerScores.put("Меч", 4);
        answerScores.put("Книга", 5);
        answerScores.put("Не нуждаюсь", 6);

        answerScores.put("Высоты", 1);
        answerScores.put("Заточения", 2);
        answerScores.put("Предательства", 3);
        answerScores.put("Одиночества", 4);
        answerScores.put("Зла", 5);
        answerScores.put("Ничего)", 6);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startButton.setVisibility(View.VISIBLE);
                resultImageView.setVisibility(View.GONE);
                resultTextView.setVisibility(View.GONE);
                currentQuestionIndex = 0;
                totalScore = 0;
                showQuestion();
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showQuestion();
                startButton.setVisibility(View.GONE);
            }
        });

        answerButtons = new Button[]{
                findViewById(R.id.answerButton1),
                findViewById(R.id.answerButton2),
                findViewById(R.id.answerButton3),
                findViewById(R.id.answerButton4),
                findViewById(R.id.answerButton5),
                findViewById(R.id.answerButton6)
        };

        for (int i = 0; i < answerButtons.length; i++) {
            final int buttonIndex = i;
            answerButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Получаем текст ответа с кнопки
                    String buttonText = answerButtons[buttonIndex].getText().toString();

                    // Получаем соответствующее количество очков из карты
                    Integer score = answerScores.get(buttonText);

                    // Если количество очков не равно null, увеличиваем сумму очков
                    if (score != null) {
                        totalScore += score;

                    } else {
                        Log.e("TestActivity", "Score not defined for answer: " + buttonText);
                    }
                    // Переходим к следующему вопросу
                    currentQuestionIndex++;
                    // Проверяем, есть ли еще вопросы
                    if (currentQuestionIndex < questions.length) {
                        showQuestion();
                    } else {
                        // Показываем результат, если это был последний вопрос
                        showResult();
                        // Скрываем поле с вопросом
                        questionTextView.setVisibility(View.GONE);
                    }
                }
            });
        }
    }
    private void showQuestion() {
        if (currentQuestionIndex < questions.length) {
            questionTextView.setText(questions[currentQuestionIndex]);
            if (currentQuestionIndex < answerOptions.length) {
                String[] currentAnswers = answerOptions[currentQuestionIndex];
                for (int i = 0; i < answerButtons.length; i++) {
                    if (i < currentAnswers.length) {
                        answerButtons[i].setText(currentAnswers[i]);
                        answerButtons[i].setVisibility(View.VISIBLE);
                    } else {
                        answerButtons[i].setVisibility(View.GONE);
                    }
                }
            }
        }
    }
    private void showResult() {
        // Скрываем кнопки ответов
        for (Button button : answerButtons) {
            button.setVisibility(View.GONE);
        }

        // Определяем результат на основе суммарных очков
        int resultIndex;
        if (totalScore <= 10) {
            resultIndex = 0;
        } else if (totalScore >= 11 && totalScore <= 15) {
            resultIndex = 1;
        } else if (totalScore >= 16 && totalScore <= 20) {
            resultIndex = 2;
        } else if (totalScore >= 21 && totalScore <= 25) {
            resultIndex = 3;
        } else if (totalScore >= 26 && totalScore <= 30) {
            resultIndex = 4;
        } else {
            resultIndex = 5;
        }

        // Отображаем изображение и текст результата
        switch (resultIndex) {
            case 0:
                resultImageView.setImageResource(R.drawable.vozdux);
                resultTextView.setText("Ты - ведьма воздуха. Ты - свободная духом и неукротимая сила природы, стремящаяся к гармонии и равновесию в мире.Ты - надежный и верный друг, готовый оказать поддержку и защиту тем, кто нуждается в помощи.Ты обладаешь легкостью и подвижностью духа, всегда стремишься к свободе и независимости. Твоя натура подобна ветру, который свободно скользит между деревьями, неукротим и непостоянен. Ты открыта новым идеям и приключениям, стремишься к познанию мира и самопознанию.");
                break;
            case 1:
                resultImageView.setImageResource(R.drawable.zemla);
                resultTextView.setText("Ты - ведьма земли. Твой характер глубоко связан с природой и всеми её проявлениями. Ты обладаешь твердым и устойчивым духом, как земля под ногами. Ты спокойна, уравновешена и терпелива, как корни древних деревьев, проникающие в глубины земли.Твоя связь с землей делает тебя практичной и рациональной. Ты умеешь находить решения, которые основаны на земных принципах и здравом смысле. Твоя преданность и надежность делают тебя надежным опорой для тех, кто нуждается в поддержке.");
                break;
            case 2:
                resultImageView.setImageResource(R.drawable.voda);
                resultTextView.setText("Ты - ведьма воды.Ты - источник жизни и обновления, подобно воде, которая приносит в сухие земли благодать и плодородие. Твоя способность облегчать страдания и исцелять раны делает тебя ценным искателем истинной гармонии и равновесия. Ты - источник жизни и обновления, подобно воде, которая приносит в сухие земли благодать и плодородие. Твоя способность облегчать страдания и исцелять раны делает тебя ценным искателем истинной гармонии и равновесия.");
                break;
            case 3:
                resultImageView.setImageResource(R.drawable.ogon);
                resultTextView.setText("Ты - ведьма огня. Твоя сущность подобна пламени, яркой и страстной, полной энергии и жизненной силы. Ты обладаешь сильным характером и горячим темпераментом, который не оставляет равнодушным никого из тех, кто встречает тебя. Твоя страсть и решимость делают тебя целеустремленной и настойчивой в достижении своих целей. Ты не боишься вызовов и готова принимать риски, чтобы добиться успеха во всем, что делаешь. Твоя целеустремленность и смелость вдохновляют окружающих и мотивируют их следовать за тобой.");
                break;
            case 4:
                resultImageView.setImageResource(R.drawable.svet);
                resultTextView.setText("Ты - ведьма света. Твоя сущность наполнена светом и добротой, и ты являешься источником света и надежды для тех, кто нуждается в помощи и поддержке. Твоя натура добрая и сострадательная, и ты всегда готова прийти на помощь другим в их трудные моменты. Твоя мудрость и внутренний свет делают тебя мудрым советником и наставником, которому можно доверять и на кого можно полагаться. Твои слова и поступки всегда направлены на вдохновение и просвещение других, и ты стремишься к тому, чтобы каждый человек осознал свой внутренний свет и силу.");
                break;
            case 5:
                resultImageView.setImageResource(R.drawable.tma);
                resultTextView.setText("Ты - ведьма тьмы. Твоя сущность пронизана загадочностью и магией, и ты являешься хранительницей темных сил и тайн. Твоя натура загадочная и непредсказуемая, и ты обладаешь уникальным способом овладения тьмой и её энергией.Твоя сила и власть проистекают из темных глубин и недра, и ты способна управлять тьмой так, чтобы она служила твоим целям. Ты обладаешь уникальным чувством интуиции и способностью видеть сквозь тьму, что делает тебя мудрым советником и провидцем.");
                break;
        }
    }
    public void GoBack4(View v) {
        Intent intent = new Intent(this, Homeactivity.class);
        startActivity(intent);
    }
}
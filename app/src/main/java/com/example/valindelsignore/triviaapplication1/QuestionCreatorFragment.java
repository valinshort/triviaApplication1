package com.example.valindelsignore.triviaapplication1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import javax.security.auth.callback.Callback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuestionCreatorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionCreatorFragment extends Fragment {


    @BindView(R.id.question_Input)
    protected EditText questionInput;

    @BindView(R.id.wrong_Answer1)
    protected EditText wrongAnswer1;

    @BindView(R.id.wrong_Answer_2)
    protected EditText wrongAnswer_2;

    @BindView(R.id.wrong_Answer3)
    protected EditText wrongAnswer3;

    @BindView(R.id.correct_Answer)
    protected EditText correctAnswer;

    private Callback callback;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_question_creator, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    public static QuestionCreatorFragment newInstance() {
        QuestionCreatorFragment fragment = new QuestionCreatorFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @OnClick(R.id.save_question_button)
    protected void saveQuestionclicked() {
        if (questionInput.getText().toString().isEmpty() || correctAnswer.getText().toString().isEmpty()
                || wrongAnswer1.getText().toString().isEmpty() || wrongAnswer_2.getText().toString().isEmpty()
                || wrongAnswer3.getText().toString().isEmpty()) {
            Toast.makeText(getActivity(), "All feilds are required", Toast.LENGTH_LONG).show();

        } else {
            String questionTitle = questionInput.getText().toString();
            String correct = correctAnswer.getText().toString();
            String firstWrong = wrongAnswer1.getText().toString();
            String secondWrong = wrongAnswer_2.getText().toString();
            String thirdWrong = wrongAnswer3.getText().toString();


        }
    }

    public interface Callback {
        void saveQuestion();
    }

    public void attachView(Callback callback) {
        this.callback = callback;
    }
}

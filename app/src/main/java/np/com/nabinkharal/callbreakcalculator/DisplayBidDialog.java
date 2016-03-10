package np.com.nabinkharal.callbreakcalculator;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

 class DisplayBidDialog extends DialogFragment {
    String[] the_names;
    TextView name1, name2, name3, name4;
    EditText bid1, bid2, bid3, bid4;
    int button_id;

    public DisplayBidDialog(String[] the_names, int button_id) {
        this.the_names = the_names;
        this.button_id = button_id;

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        final View dialog_box = inflater.inflate(R.layout.dialog_box, null);
        name1 = (TextView) dialog_box.findViewById(R.id.name1);
        name1.setText(the_names[0]);
        name2 = (TextView) dialog_box.findViewById(R.id.name2);
        name2.setText(the_names[1]);
        name3 = (TextView) dialog_box.findViewById(R.id.name3);
        name3.setText(the_names[2]);
        name4 = (TextView) dialog_box.findViewById(R.id.name4);
        name4.setText(the_names[3]);


        bid1 = (EditText) dialog_box.findViewById(R.id.bid1);
        bid1.setFilters(new InputFilter[]{new Filter(1, 13)});
        bid2 = (EditText) dialog_box.findViewById(R.id.bid2);
        bid2.setFilters(new InputFilter[]{new Filter(1, 13)});
        bid3 = (EditText) dialog_box.findViewById(R.id.bid3);
        bid3.setFilters(new InputFilter[]{new Filter(1, 13)});
        bid4 = (EditText) dialog_box.findViewById(R.id.bid4);
        bid4.setFilters(new InputFilter[]{new Filter(1, 13)});


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.dialogTheme);
        builder.setTitle("Bid info");
        builder.setMessage("Please enter the bid amount of corresponding players");
        builder.setView(dialog_box);
        builder.setPositiveButton("done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                switch (button_id) {
                    case R.id.bid_button1:
                        mehdi.sakout.fancybuttons.FancyButton the_button = (mehdi.sakout.fancybuttons.FancyButton) getActivity().findViewById(button_id);
                        the_button.setVisibility(View.INVISIBLE);

                        View first_score = getActivity().findViewById(R.id.first_score);
                        first_score.setVisibility(View.VISIBLE);
                        TextView score1 = (TextView) first_score.findViewById(R.id.bid1);
                        TextView score2 = (TextView) first_score.findViewById(R.id.bid2);
                        TextView score4 = (TextView) first_score.findViewById(R.id.bid4);
                        TextView score3 = (TextView) first_score.findViewById(R.id.bid3);

                        View final_score = getActivity().findViewById(R.id.final_score);
                        TextView final_score1 = (TextView) final_score.findViewById(R.id.bid1);
                        TextView final_score2 = (TextView) final_score.findViewById(R.id.bid2);
                        TextView final_score3 = (TextView) final_score.findViewById(R.id.bid3);
                        TextView final_score4 = (TextView) final_score.findViewById(R.id.bid4);


                        score1.setText(bid1.getText());
                        score2.setText(bid2.getText());
                        score3.setText(bid3.getText());
                        score4.setText(bid4.getText());

                        final_score1.setText(String.valueOf((Float.valueOf(final_score1.getText().toString()) + (Float.valueOf(bid1.getText().toString())))));
                        final_score2.setText(String.valueOf((Float.valueOf(final_score2.getText().toString()) + (Float.valueOf(bid2.getText().toString())))));
                        final_score3.setText(String.valueOf((Float.valueOf(final_score3.getText().toString()) + (Float.valueOf(bid3.getText().toString())))));
                        final_score4.setText(String.valueOf((Float.valueOf(final_score4.getText().toString()) + (Float.valueOf(bid4.getText().toString())))));
                        mehdi.sakout.fancybuttons.FancyButton next_button = (mehdi.sakout.fancybuttons.FancyButton) getActivity().findViewById(R.id.confirm_button1);
                        next_button.setVisibility(View.VISIBLE);
                        break;

                    case R.id.bid_button2:
                        mehdi.sakout.fancybuttons.FancyButton the_button1 = (mehdi.sakout.fancybuttons.FancyButton) getActivity().findViewById(button_id);
                        the_button1.setVisibility(View.INVISIBLE);

                        View second_score = getActivity().findViewById(R.id.second_score);
                        second_score.setVisibility(View.VISIBLE);
                        View final_1score = getActivity().findViewById(R.id.final_score);
                        TextView final_1score1 = (TextView) final_1score.findViewById(R.id.bid1);
                        TextView final_1score2 = (TextView) final_1score.findViewById(R.id.bid2);
                        TextView final_1score3 = (TextView) final_1score.findViewById(R.id.bid3);
                        TextView final_1score4 = (TextView) final_1score.findViewById(R.id.bid4);

                        TextView score11 = (TextView) second_score.findViewById(R.id.bid1);
                        TextView score12 = (TextView) second_score.findViewById(R.id.bid2);
                        TextView score14 = (TextView) second_score.findViewById(R.id.bid4);
                        TextView score13 = (TextView) second_score.findViewById(R.id.bid3);

                        score11.setText(bid1.getText());
                        score12.setText(bid2.getText());
                        score13.setText(bid3.getText());
                        score14.setText(bid4.getText());

                        final_1score1.setText(String.valueOf((Float.valueOf(final_1score1.getText().toString()) + (Float.valueOf(bid1.getText().toString())))));
                        final_1score2.setText(String.valueOf((Float.valueOf(final_1score2.getText().toString()) + (Float.valueOf(bid2.getText().toString())))));
                        final_1score3.setText(String.valueOf((Float.valueOf(final_1score3.getText().toString()) + (Float.valueOf(bid3.getText().toString())))));
                        final_1score4.setText(String.valueOf((Float.valueOf(final_1score4.getText().toString()) + (Float.valueOf(bid4.getText().toString())))));
                        mehdi.sakout.fancybuttons.FancyButton next_button1 = (mehdi.sakout.fancybuttons.FancyButton) getActivity().findViewById(R.id.confirm_button2);
                        next_button1.setVisibility(View.VISIBLE);

                        break;

                    case R.id.bid_button3:
                        mehdi.sakout.fancybuttons.FancyButton the_button2 = (mehdi.sakout.fancybuttons.FancyButton) getActivity().findViewById(button_id);
                        the_button2.setVisibility(View.INVISIBLE);

                        View third_score = getActivity().findViewById(R.id.third_score);
                        third_score.setVisibility(View.VISIBLE);
                        View final_2score = getActivity().findViewById(R.id.final_score);
                        TextView final_2score1 = (TextView) final_2score.findViewById(R.id.bid1);
                        TextView final_2score2 = (TextView) final_2score.findViewById(R.id.bid2);
                        TextView final_2score3 = (TextView) final_2score.findViewById(R.id.bid3);
                        TextView final_2score4 = (TextView) final_2score.findViewById(R.id.bid4);

                        TextView score21 = (TextView) third_score.findViewById(R.id.bid1);
                        TextView score22 = (TextView) third_score.findViewById(R.id.bid2);
                        TextView score24 = (TextView) third_score.findViewById(R.id.bid4);
                        TextView score23 = (TextView) third_score.findViewById(R.id.bid3);

                        score21.setText(bid1.getText());
                        score22.setText(bid2.getText());
                        score23.setText(bid3.getText());
                        score24.setText(bid4.getText());

                        final_2score1.setText(String.valueOf((Float.valueOf(final_2score1.getText().toString()) + (Float.valueOf(bid1.getText().toString())))));
                        final_2score2.setText(String.valueOf((Float.valueOf(final_2score2.getText().toString()) + (Float.valueOf(bid2.getText().toString())))));
                        final_2score3.setText(String.valueOf((Float.valueOf(final_2score3.getText().toString()) + (Float.valueOf(bid3.getText().toString())))));
                        final_2score4.setText(String.valueOf((Float.valueOf(final_2score4.getText().toString()) + (Float.valueOf(bid4.getText().toString())))));
                        mehdi.sakout.fancybuttons.FancyButton next_button2 = (mehdi.sakout.fancybuttons.FancyButton) getActivity().findViewById(R.id.confirm_button3);
                        next_button2.setVisibility(View.VISIBLE);

                        break;

                    case R.id.bid_button4:
                        mehdi.sakout.fancybuttons.FancyButton the_button3 = (mehdi.sakout.fancybuttons.FancyButton) getActivity().findViewById(button_id);
                        the_button3.setVisibility(View.INVISIBLE);

                        View fourth_score = getActivity().findViewById(R.id.fourth_score);
                        fourth_score.setVisibility(View.VISIBLE);

                        View final_3score = getActivity().findViewById(R.id.final_score);
                        TextView final_3score1 = (TextView) final_3score.findViewById(R.id.bid1);
                        TextView final_3score2 = (TextView) final_3score.findViewById(R.id.bid2);
                        TextView final_3score3 = (TextView) final_3score.findViewById(R.id.bid3);
                        TextView final_3score4 = (TextView) final_3score.findViewById(R.id.bid4);

                        TextView score31 = (TextView) fourth_score.findViewById(R.id.bid1);
                        TextView score32 = (TextView) fourth_score.findViewById(R.id.bid2);
                        TextView score34 = (TextView) fourth_score.findViewById(R.id.bid4);
                        TextView score33 = (TextView) fourth_score.findViewById(R.id.bid3);

                        score31.setText(bid1.getText());
                        score32.setText(bid2.getText());
                        score33.setText(bid3.getText());
                        score34.setText(bid4.getText());

                        final_3score1.setText(String.valueOf((Float.valueOf(final_3score1.getText().toString()) + (Float.valueOf(bid1.getText().toString())))));
                        final_3score2.setText(String.valueOf((Float.valueOf(final_3score2.getText().toString()) + (Float.valueOf(bid2.getText().toString())))));
                        final_3score3.setText(String.valueOf((Float.valueOf(final_3score3.getText().toString()) + (Float.valueOf(bid3.getText().toString())))));
                        final_3score4.setText(String.valueOf((Float.valueOf(final_3score4.getText().toString()) + (Float.valueOf(bid4.getText().toString())))));
                        mehdi.sakout.fancybuttons.FancyButton next_button3 = (mehdi.sakout.fancybuttons.FancyButton) getActivity().findViewById(R.id.confirm_button4);
                        next_button3.setVisibility(View.VISIBLE);

                        break;
                    case R.id.bid_button5:
                        mehdi.sakout.fancybuttons.FancyButton the_button4 = (mehdi.sakout.fancybuttons.FancyButton) getActivity().findViewById(button_id);
                        the_button4.setVisibility(View.INVISIBLE);

                        View fifth_score = getActivity().findViewById(R.id.fifth_score);
                        fifth_score.setVisibility(View.VISIBLE);
                        View final_4score = getActivity().findViewById(R.id.full_final);
                        final_4score.setVisibility(View.VISIBLE);
                        TextView final_4score1 = (TextView) final_4score.findViewById(R.id.bid1);
                        TextView final_4score2 = (TextView) final_4score.findViewById(R.id.bid2);
                        TextView final_4score3 = (TextView) final_4score.findViewById(R.id.bid3);
                        TextView final_4score4 = (TextView) final_4score.findViewById(R.id.bid4);

                        TextView score41 = (TextView) fifth_score.findViewById(R.id.bid1);
                        TextView score42 = (TextView) fifth_score.findViewById(R.id.bid2);
                        TextView score44 = (TextView) fifth_score.findViewById(R.id.bid4);
                        TextView score43 = (TextView) fifth_score.findViewById(R.id.bid3);

                        score41.setText(bid1.getText());
                        score42.setText(bid2.getText());
                        score43.setText(bid3.getText());
                        score44.setText(bid4.getText());

                        final_4score1.setText(String.valueOf((Float.valueOf(final_4score1.getText().toString()) + (Float.valueOf(bid1.getText().toString())))));
                        final_4score2.setText(String.valueOf((Float.valueOf(final_4score2.getText().toString()) + (Float.valueOf(bid2.getText().toString())))));
                        final_4score3.setText(String.valueOf((Float.valueOf(final_4score3.getText().toString()) + (Float.valueOf(bid3.getText().toString())))));
                        final_4score4.setText(String.valueOf((Float.valueOf(final_4score4.getText().toString()) + (Float.valueOf(bid4.getText().toString())))));
                        mehdi.sakout.fancybuttons.FancyButton next_button4 = (mehdi.sakout.fancybuttons.FancyButton) getActivity().findViewById(R.id.confirm_button5);
                        next_button4.setVisibility(View.VISIBLE);

                        break;
                }
            }
        });

        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        return builder.show();
    }
}
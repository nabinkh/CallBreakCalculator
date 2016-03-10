package np.com.nabinkharal.callbreakcalculator;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import mehdi.sakout.fancybuttons.FancyButton;

public class DisplayConfirmDialog extends DialogFragment {

    TextView name1, name2, name3, name4;
    String[] the_names;
    EditText confirmed1, confirmed2, confirmed3, confirmed4;
    int button_id;

    public DisplayConfirmDialog(String[] the_names, int button_id) {
        this.the_names = the_names;
        this.button_id = button_id;
    }

    @NonNull
    @Override

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialog_box = inflater.inflate(R.layout.dialog_box, null);

        name1 = (TextView) dialog_box.findViewById(R.id.name1);
        name1.setText(the_names[0]);
        name2 = (TextView) dialog_box.findViewById(R.id.name2);
        name2.setText(the_names[1]);
        name3 = (TextView) dialog_box.findViewById(R.id.name3);
        name3.setText(the_names[2]);
        name4 = (TextView) dialog_box.findViewById(R.id.name4);
        name4.setText(the_names[3]);

        confirmed1 = (EditText) dialog_box.findViewById(R.id.bid1);
        confirmed1.setFilters(new InputFilter[]{new Filter(1, 13)});
        confirmed2 = (EditText) dialog_box.findViewById(R.id.bid2);
        confirmed2.setFilters(new InputFilter[]{new Filter(1, 13)});
        confirmed3 = (EditText) dialog_box.findViewById(R.id.bid3);
        confirmed3.setFilters(new InputFilter[]{new Filter(1, 13)});
        confirmed4 = (EditText) dialog_box.findViewById(R.id.bid4);
        confirmed4.setFilters(new InputFilter[]{new Filter(1, 13)});

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.dialogTheme1);
        builder.setTitle("Conformation");
        builder.setMessage("Enter the hands that each players got");
        builder.setView(dialog_box);
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if ((Float.valueOf(confirmed1.getText().toString()) + Float.valueOf(confirmed2.getText().toString()) + Float.valueOf(confirmed3.getText().toString()) + Float.valueOf(confirmed4.getText().toString())) != 13) {
                    dialog.cancel();
                } else {
                    switch (button_id) {
                        case R.id.confirm_button1:
                            mehdi.sakout.fancybuttons.FancyButton confirm_button1 = (mehdi.sakout.fancybuttons.FancyButton) getActivity().findViewById(button_id);
                            confirm_button1.setVisibility(View.INVISIBLE);
                            View final_score = getActivity().findViewById(R.id.final_score);
                            TextView final_score1 = (TextView) final_score.findViewById(R.id.bid1);
                            TextView final_score2 = (TextView) final_score.findViewById(R.id.bid2);
                            TextView final_score3 = (TextView) final_score.findViewById(R.id.bid3);
                            TextView final_score4 = (TextView) final_score.findViewById(R.id.bid4);


                            View first_score = getActivity().findViewById(R.id.first_score);


                            TextView score1 = (TextView) first_score.findViewById(R.id.bid1);
                            TextView score2 = (TextView) first_score.findViewById(R.id.bid2);
                            TextView score4 = (TextView) first_score.findViewById(R.id.bid4);
                            TextView score3 = (TextView) first_score.findViewById(R.id.bid3);
                            final_score1.setText(String.valueOf((Float.valueOf(final_score1.getText().toString()) - (Float.valueOf(score1.getText().toString())))));
                            final_score2.setText(String.valueOf((Float.valueOf(final_score2.getText().toString()) - (Float.valueOf(score2.getText().toString())))));
                            final_score3.setText(String.valueOf((Float.valueOf(final_score3.getText().toString()) - (Float.valueOf(score3.getText().toString())))));
                            final_score4.setText(String.valueOf((Float.valueOf(final_score4.getText().toString()) - (Float.valueOf(score4.getText().toString())))));

                            if (confirmed1.getText() == score1.getText()) {

                                score1.setTextColor(getResources().getColor(R.color.green));
                                return;
                            } else {
                                if ((Float.valueOf(confirmed1.getText().toString())) < (Float.valueOf(score1.getText().toString()))) {
                                    score1.setText("-" + score1.getText());
                                    score1.setTextColor(getResources().getColor(R.color.red));
                                } else {
                                    score1.setText(String.valueOf(Float.valueOf(score1.getText().toString()) + Float.valueOf(String.valueOf((Float.valueOf(confirmed1.getText().toString())) - (Float.valueOf(score1.getText().toString())))) / 10.0));
                                    score1.setTextColor(getResources().getColor(R.color.green));
                                }
                            }
                            if ((Float.valueOf(confirmed2.getText().toString())) == (Float.valueOf(score2.getText().toString()))) {
                                score2.setTextColor(getResources().getColor(R.color.green));
                                return;
                            } else {
                                if ((Float.valueOf(confirmed2.getText().toString())) < (Float.valueOf(score2.getText().toString()))) {
                                    score2.setText("-" + score2.getText());
                                    score2.setTextColor(getResources().getColor(R.color.red));
                                } else {
                                    score2.setText(String.valueOf(Float.valueOf(score2.getText().toString()) + Float.valueOf(String.valueOf((Float.valueOf(confirmed2.getText().toString())) - (Float.valueOf(score2.getText().toString())))) / 10.0));
                                    score2.setTextColor(getResources().getColor(R.color.green));
                                }
                            }
                            if ((Float.valueOf(confirmed3.getText().toString())) == (Float.valueOf(score3.getText().toString()))) {
                                score3.setTextColor(getResources().getColor(R.color.green));
                                return;
                            } else {
                                if ((Float.valueOf(confirmed3.getText().toString())) < (Float.valueOf(score3.getText().toString()))) {
                                    score3.setText("-" + score3.getText());
                                    score3.setTextColor(getResources().getColor(R.color.red));
                                } else {
                                    score3.setText(String.valueOf(Float.valueOf(score3.getText().toString()) + Float.valueOf(String.valueOf((Float.valueOf(confirmed3.getText().toString())) - (Float.valueOf(score3.getText().toString())))) / 10.0));
                                    score3.setTextColor(getResources().getColor(R.color.green));
                                }
                            }
                            if ((Float.valueOf(confirmed4.getText().toString())) == (Float.valueOf(score4.getText().toString()))) {
                                score4.setTextColor(getResources().getColor(R.color.green));
                                return;
                            } else {
                                if ((Float.valueOf(confirmed4.getText().toString())) < (Float.valueOf(score4.getText().toString()))) {
                                    score4.setText("-" + score4.getText());
                                    score4.setTextColor(getResources().getColor(R.color.red));
                                } else {
                                    score4.setText(String.valueOf(Float.valueOf(score4.getText().toString()) + Float.valueOf(String.valueOf((Float.valueOf(confirmed4.getText().toString())) - (Float.valueOf(score4.getText().toString())))) / 10.0));
                                    score4.setTextColor(getResources().getColor(R.color.green));
                                }
                            }
                            final_score1.setText(String.valueOf((Float.valueOf(final_score1.getText().toString()) + (Float.valueOf(score1.getText().toString())))));
                            final_score2.setText(String.valueOf((Float.valueOf(final_score2.getText().toString()) + (Float.valueOf(score2.getText().toString())))));
                            final_score3.setText(String.valueOf((Float.valueOf(final_score3.getText().toString()) + (Float.valueOf(score3.getText().toString())))));
                            final_score4.setText(String.valueOf((Float.valueOf(final_score4.getText().toString()) + (Float.valueOf(score4.getText().toString())))));
                            mehdi.sakout.fancybuttons.FancyButton next_button = (mehdi.sakout.fancybuttons.FancyButton) getActivity().findViewById(R.id.bid_button2);
                            next_button.setVisibility(View.VISIBLE);
                            break;

                        case R.id.confirm_button2:
                            FancyButton confirm_button2 = (FancyButton) getActivity().findViewById(button_id);
                            confirm_button2.setVisibility(View.INVISIBLE);
                            View second_score = getActivity().findViewById(R.id.second_score);

                            View final_1score = getActivity().findViewById(R.id.final_score);
                            TextView final_1score1 = (TextView) final_1score.findViewById(R.id.bid1);
                            TextView final_1score2 = (TextView) final_1score.findViewById(R.id.bid2);
                            TextView final_1score3 = (TextView) final_1score.findViewById(R.id.bid3);
                            TextView final_1score4 = (TextView) final_1score.findViewById(R.id.bid4);

                            TextView score11 = (TextView) second_score.findViewById(R.id.bid1);
                            TextView score12 = (TextView) second_score.findViewById(R.id.bid2);
                            TextView score14 = (TextView) second_score.findViewById(R.id.bid4);
                            TextView score13 = (TextView) second_score.findViewById(R.id.bid3);
                            final_1score1.setText(String.valueOf((Float.valueOf(final_1score1.getText().toString()) - (Float.valueOf(score11.getText().toString())))));
                            final_1score2.setText(String.valueOf((Float.valueOf(final_1score2.getText().toString()) - (Float.valueOf(score12.getText().toString())))));
                            final_1score3.setText(String.valueOf((Float.valueOf(final_1score3.getText().toString()) - (Float.valueOf(score13.getText().toString())))));
                            final_1score4.setText(String.valueOf((Float.valueOf(final_1score4.getText().toString()) - (Float.valueOf(score14.getText().toString())))));
                            if (confirmed1.getText() == score11.getText()) {
                                score11.setTextColor(getResources().getColor(R.color.green));
                                return;
                            } else {
                                if ((Float.valueOf(confirmed1.getText().toString())) < (Float.valueOf(score11.getText().toString()))) {
                                    score11.setText("-" + score11.getText());
                                    score11.setTextColor(getResources().getColor(R.color.red));
                                } else {
                                    score11.setText(String.valueOf(Float.valueOf(score11.getText().toString()) + Float.valueOf(String.valueOf((Float.valueOf(confirmed1.getText().toString())) - (Float.valueOf(score11.getText().toString())))) / 10.0));
                                    score11.setTextColor(getResources().getColor(R.color.green));
                                }
                            }
                            if ((Float.valueOf(confirmed2.getText().toString())) == (Float.valueOf(score12.getText().toString()))) {
                                score12.setTextColor(getResources().getColor(R.color.green));
                                return;
                            } else {
                                if ((Float.valueOf(confirmed2.getText().toString())) < (Float.valueOf(score12.getText().toString()))) {
                                    score12.setTextColor(getResources().getColor(R.color.red));
                                    score12.setText("-" + score12.getText());
                                } else {
                                    score12.setTextColor(getResources().getColor(R.color.green));
                                    score12.setText(String.valueOf(Float.valueOf(score12.getText().toString()) + Float.valueOf(String.valueOf((Float.valueOf(confirmed2.getText().toString())) - (Float.valueOf(score12.getText().toString())))) / 10.0));
                                }
                            }
                            if ((Float.valueOf(confirmed3.getText().toString())) == (Float.valueOf(score13.getText().toString()))) {
                                score13.setTextColor(getResources().getColor(R.color.green));
                                return;
                            } else {
                                if ((Float.valueOf(confirmed3.getText().toString())) < (Float.valueOf(score13.getText().toString()))) {
                                    score13.setTextColor(getResources().getColor(R.color.red));
                                    score13.setText("-" + score13.getText());
                                } else {
                                    score13.setTextColor(getResources().getColor(R.color.green));
                                    score13.setText(String.valueOf(Float.valueOf(score13.getText().toString()) + Float.valueOf(String.valueOf((Float.valueOf(confirmed3.getText().toString())) - (Float.valueOf(score13.getText().toString())))) / 10.0));
                                }
                            }
                            if ((Float.valueOf(confirmed4.getText().toString())) == (Float.valueOf(score14.getText().toString()))) {
                                score14.setTextColor(getResources().getColor(R.color.green));
                                return;

                            } else {
                                if ((Float.valueOf(confirmed4.getText().toString())) < (Float.valueOf(score14.getText().toString()))) {
                                    score14.setText("-" + score14.getText());
                                    score14.setTextColor(getResources().getColor(R.color.red));
                                } else {
                                    score14.setTextColor(getResources().getColor(R.color.green));
                                    score14.setText(String.valueOf(Float.valueOf(score14.getText().toString()) + Float.valueOf(String.valueOf((Float.valueOf(confirmed4.getText().toString())) - (Float.valueOf(score14.getText().toString())))) / 10.0));

                                }
                            }
                            final_1score1.setText(String.valueOf((Float.valueOf(final_1score1.getText().toString()) + (Float.valueOf(score11.getText().toString())))));
                            final_1score2.setText(String.valueOf((Float.valueOf(final_1score2.getText().toString()) + (Float.valueOf(score12.getText().toString())))));
                            final_1score3.setText(String.valueOf((Float.valueOf(final_1score3.getText().toString()) + (Float.valueOf(score13.getText().toString())))));
                            final_1score4.setText(String.valueOf((Float.valueOf(final_1score4.getText().toString()) + (Float.valueOf(score14.getText().toString())))));
                            FancyButton next_button1 = (FancyButton) getActivity().findViewById(R.id.bid_button3);
                            next_button1.setVisibility(View.VISIBLE);

                            break;
                        case R.id.confirm_button3:
                            mehdi.sakout.fancybuttons.FancyButton confirm_button3 = (mehdi.sakout.fancybuttons.FancyButton) getActivity().findViewById(button_id);
                            confirm_button3.setVisibility(View.INVISIBLE);
                            View third_score = getActivity().findViewById(R.id.third_score);

                            View final_2score = getActivity().findViewById(R.id.final_score);
                            TextView final_2score1 = (TextView) final_2score.findViewById(R.id.bid1);
                            TextView final_2score2 = (TextView) final_2score.findViewById(R.id.bid2);
                            TextView final_2score3 = (TextView) final_2score.findViewById(R.id.bid3);
                            TextView final_2score4 = (TextView) final_2score.findViewById(R.id.bid4);

                            TextView score21 = (TextView) third_score.findViewById(R.id.bid1);
                            TextView score22 = (TextView) third_score.findViewById(R.id.bid2);
                            TextView score24 = (TextView) third_score.findViewById(R.id.bid4);
                            TextView score23 = (TextView) third_score.findViewById(R.id.bid3);
                            final_2score1.setText(String.valueOf((Float.valueOf(final_2score1.getText().toString()) - (Float.valueOf(score21.getText().toString())))));
                            final_2score2.setText(String.valueOf((Float.valueOf(final_2score2.getText().toString()) - (Float.valueOf(score22.getText().toString())))));
                            final_2score3.setText(String.valueOf((Float.valueOf(final_2score3.getText().toString()) - (Float.valueOf(score23.getText().toString())))));
                            final_2score4.setText(String.valueOf((Float.valueOf(final_2score4.getText().toString()) - (Float.valueOf(score24.getText().toString())))));
                            if (confirmed1.getText() == score21.getText()) {
                                score21.setTextColor(getResources().getColor(R.color.green));
                                return;
                            } else {
                                if ((Float.valueOf(confirmed1.getText().toString())) < (Float.valueOf(score21.getText().toString()))) {
                                    score21.setText("-" + score21.getText());
                                    score21.setTextColor(getResources().getColor(R.color.red));
                                } else {
                                    score21.setTextColor(getResources().getColor(R.color.green));
                                    score21.setText(String.valueOf(Float.valueOf(score21.getText().toString()) + Float.valueOf(String.valueOf((Float.valueOf(confirmed1.getText().toString())) - (Float.valueOf(score21.getText().toString())))) / 10.0));
                                }
                            }
                            if ((Float.valueOf(confirmed2.getText().toString())) == (Float.valueOf(score22.getText().toString()))) {
                                score22.setTextColor(getResources().getColor(R.color.green));
                                return;
                            } else {
                                if ((Float.valueOf(confirmed2.getText().toString())) < (Float.valueOf(score22.getText().toString()))) {
                                    score22.setTextColor(getResources().getColor(R.color.red));
                                    score22.setText("-" + score22.getText());
                                } else {
                                    score22.setTextColor(getResources().getColor(R.color.green));
                                    score22.setText(String.valueOf(Float.valueOf(score22.getText().toString()) + Float.valueOf(String.valueOf((Float.valueOf(confirmed2.getText().toString())) - (Float.valueOf(score22.getText().toString())))) / 10.0));
                                }
                            }
                            if ((Float.valueOf(confirmed3.getText().toString())) == (Float.valueOf(score23.getText().toString()))) {
                                score23.setTextColor(getResources().getColor(R.color.green));
                                return;
                            } else {
                                if ((Float.valueOf(confirmed3.getText().toString())) < (Float.valueOf(score23.getText().toString()))) {
                                    score23.setText("-" + score23.getText());
                                    score23.setTextColor(getResources().getColor(R.color.red));
                                } else {
                                    score23.setTextColor(getResources().getColor(R.color.green));
                                    score23.setText(String.valueOf(Float.valueOf(score23.getText().toString()) + Float.valueOf(String.valueOf((Float.valueOf(confirmed3.getText().toString())) - (Float.valueOf(score23.getText().toString())))) / 10.0));
                                }
                            }
                            if ((Float.valueOf(confirmed4.getText().toString())) == (Float.valueOf(score24.getText().toString()))) {
                                score24.setTextColor(getResources().getColor(R.color.green));
                                return;
                            } else {
                                if ((Float.valueOf(confirmed4.getText().toString())) < (Float.valueOf(score24.getText().toString()))) {
                                    score24.setText("-" + score24.getText());
                                    score24.setTextColor(getResources().getColor(R.color.red));
                                } else {
                                    score24.setTextColor(getResources().getColor(R.color.green));
                                    score24.setText(String.valueOf(Float.valueOf(score24.getText().toString()) + Float.valueOf(String.valueOf((Float.valueOf(confirmed4.getText().toString())) - (Float.valueOf(score24.getText().toString())))) / 10.0));

                                }
                            }
                            final_2score1.setText(String.valueOf((Float.valueOf(final_2score1.getText().toString()) + (Float.valueOf(score21.getText().toString())))));
                            final_2score2.setText(String.valueOf((Float.valueOf(final_2score2.getText().toString()) + (Float.valueOf(score22.getText().toString())))));
                            final_2score3.setText(String.valueOf((Float.valueOf(final_2score3.getText().toString()) + (Float.valueOf(score23.getText().toString())))));
                            final_2score4.setText(String.valueOf((Float.valueOf(final_2score4.getText().toString()) + (Float.valueOf(score24.getText().toString())))));
                            mehdi.sakout.fancybuttons.FancyButton next_button2 = (mehdi.sakout.fancybuttons.FancyButton) getActivity().findViewById(R.id.bid_button4);
                            next_button2.setVisibility(View.VISIBLE);

                            break;
                        case R.id.confirm_button4:
                            mehdi.sakout.fancybuttons.FancyButton confirm_button4 = (mehdi.sakout.fancybuttons.FancyButton) getActivity().findViewById(button_id);
                            confirm_button4.setVisibility(View.INVISIBLE);

                            View fourth_score = getActivity().findViewById(R.id.fourth_score);
                            View final_3score = getActivity().findViewById(R.id.final_score);
                            TextView final_3score1 = (TextView) final_3score.findViewById(R.id.bid1);
                            TextView final_3score2 = (TextView) final_3score.findViewById(R.id.bid2);
                            TextView final_3score3 = (TextView) final_3score.findViewById(R.id.bid3);
                            TextView final_3score4 = (TextView) final_3score.findViewById(R.id.bid4);
                            View full_final = getActivity().findViewById(R.id.full_final);
                            full_final.setVisibility(View.VISIBLE);

                            TextView full_final1 = (TextView) full_final.findViewById(R.id.bid1);
                            TextView full_final2 = (TextView) full_final.findViewById(R.id.bid2);
                            TextView full_final3 = (TextView) full_final.findViewById(R.id.bid3);
                            TextView full_final4 = (TextView) full_final.findViewById(R.id.bid4);

                            TextView score31 = (TextView) fourth_score.findViewById(R.id.bid1);
                            TextView score32 = (TextView) fourth_score.findViewById(R.id.bid2);
                            TextView score34 = (TextView) fourth_score.findViewById(R.id.bid4);
                            TextView score33 = (TextView) fourth_score.findViewById(R.id.bid3);
                            final_3score1.setText(String.valueOf((Float.valueOf(final_3score1.getText().toString()) - (Float.valueOf(score31.getText().toString())))));
                            final_3score2.setText(String.valueOf((Float.valueOf(final_3score2.getText().toString()) - (Float.valueOf(score32.getText().toString())))));
                            final_3score3.setText(String.valueOf((Float.valueOf(final_3score3.getText().toString()) - (Float.valueOf(score33.getText().toString())))));
                            final_3score4.setText(String.valueOf((Float.valueOf(final_3score4.getText().toString()) - (Float.valueOf(score34.getText().toString())))));

                            if (confirmed1.getText() == score31.getText()) {
                                score31.setTextColor(getResources().getColor(R.color.green));
                                return;
                            } else {
                                if ((Float.valueOf(confirmed1.getText().toString())) < (Float.valueOf(score31.getText().toString()))) {
                                    score31.setText("-" + score31.getText());
                                    score31.setTextColor(getResources().getColor(R.color.red));
                                } else {
                                    score31.setTextColor(getResources().getColor(R.color.green));
                                    score31.setText(String.valueOf(Float.valueOf(score31.getText().toString()) + Float.valueOf(String.valueOf((Float.valueOf(confirmed1.getText().toString())) - (Float.valueOf(score31.getText().toString())))) / 10.0));
                                }
                            }
                            if ((Float.valueOf(confirmed2.getText().toString())) == (Float.valueOf(score32.getText().toString()))) {
                                score32.setTextColor(getResources().getColor(R.color.green));
                                return;
                            } else {
                                if ((Float.valueOf(confirmed2.getText().toString())) < (Float.valueOf(score32.getText().toString()))) {
                                    score32.setText("-" + score32.getText());
                                    score32.setTextColor(getResources().getColor(R.color.red));
                                } else {
                                    score32.setTextColor(getResources().getColor(R.color.green));
                                    score32.setText(String.valueOf(Float.valueOf(score32.getText().toString()) + Float.valueOf(String.valueOf((Float.valueOf(confirmed2.getText().toString())) - (Float.valueOf(score32.getText().toString())))) / 10.0));
                                }
                            }
                            if ((Float.valueOf(confirmed3.getText().toString())) == (Float.valueOf(score33.getText().toString()))) {
                                score33.setTextColor(getResources().getColor(R.color.green));
                                return;
                            } else {
                                if ((Float.valueOf(confirmed3.getText().toString())) < (Float.valueOf(score33.getText().toString()))) {
                                    score33.setText("-" + score33.getText());
                                    score33.setTextColor(getResources().getColor(R.color.red));
                                } else {
                                    score33.setTextColor(getResources().getColor(R.color.green));
                                    score33.setText(String.valueOf(Float.valueOf(score33.getText().toString()) + Float.valueOf(String.valueOf((Float.valueOf(confirmed3.getText().toString())) - (Float.valueOf(score33.getText().toString())))) / 10.0));
                                }
                            }
                            if ((Float.valueOf(confirmed4.getText().toString())) == (Float.valueOf(score34.getText().toString()))) {
                                score34.setTextColor(getResources().getColor(R.color.green));
                                return;
                            } else {
                                if ((Float.valueOf(confirmed4.getText().toString())) < (Float.valueOf(score34.getText().toString()))) {
                                    score34.setText("-" + score34.getText());
                                    score34.setTextColor(getResources().getColor(R.color.red));
                                } else {
                                    score34.setTextColor(getResources().getColor(R.color.green));
                                    score34.setText(String.valueOf(Float.valueOf(score34.getText().toString()) + Float.valueOf(String.valueOf((Float.valueOf(confirmed4.getText().toString())) - (Float.valueOf(score34.getText().toString())))) / 10.0));

                                }
                            }
                            final_3score1.setText(String.valueOf((Float.valueOf(final_3score1.getText().toString()) + (Float.valueOf(score31.getText().toString())))));
                            final_3score2.setText(String.valueOf((Float.valueOf(final_3score2.getText().toString()) + (Float.valueOf(score32.getText().toString())))));
                            final_3score3.setText(String.valueOf((Float.valueOf(final_3score3.getText().toString()) + (Float.valueOf(score33.getText().toString())))));
                            final_3score4.setText(String.valueOf((Float.valueOf(final_3score4.getText().toString()) + (Float.valueOf(score34.getText().toString())))));

                            full_final1.setText(final_3score1.getText());
                            full_final2.setText(final_3score2.getText());
                            full_final3.setText(final_3score3.getText());
                            full_final4.setText(final_3score4.getText());
                            mehdi.sakout.fancybuttons.FancyButton next_button3 = (mehdi.sakout.fancybuttons.FancyButton) getActivity().findViewById(R.id.bid_button5);
                            next_button3.setVisibility(View.VISIBLE);

                            break;

                        case R.id.confirm_button5:
                            mehdi.sakout.fancybuttons.FancyButton confirm_button5 = (mehdi.sakout.fancybuttons.FancyButton) getActivity().findViewById(button_id);
                            confirm_button5.setVisibility(View.INVISIBLE);
                            View fifth_score = getActivity().findViewById(R.id.fourth_score);

                            View full_1final = getActivity().findViewById(R.id.full_final);
                            TextView full_1final1 = (TextView) full_1final.findViewById(R.id.bid1);
                            TextView full_1final2 = (TextView) full_1final.findViewById(R.id.bid2);
                            TextView full_1final3 = (TextView) full_1final.findViewById(R.id.bid3);
                            TextView full_1final4 = (TextView) full_1final.findViewById(R.id.bid4);

                            View score_before=getActivity().findViewById(R.id.final_score);
                            TextView score_before1=(TextView) score_before.findViewById(R.id.bid1);
                            TextView score_before2=(TextView) score_before.findViewById(R.id.bid1);
                            TextView score_before3=(TextView) score_before.findViewById(R.id.bid1);
                            TextView score_before4=(TextView) score_before.findViewById(R.id.bid1);


                            TextView score41 = (TextView) fifth_score.findViewById(R.id.bid1);
                            TextView score42 = (TextView) fifth_score.findViewById(R.id.bid2);
                            TextView score44 = (TextView) fifth_score.findViewById(R.id.bid4);
                            TextView score43 = (TextView) fifth_score.findViewById(R.id.bid3);


                            full_1final1.setText(String.valueOf((Float.valueOf(score_before1.getText().toString()) - (Float.valueOf(score41.getText().toString())))));
                            full_1final2.setText(String.valueOf((Float.valueOf(score_before2.getText().toString()) - (Float.valueOf(score42.getText().toString())))));
                            full_1final3.setText(String.valueOf((Float.valueOf(score_before3.getText().toString()) - (Float.valueOf(score43.getText().toString())))));
                            full_1final4.setText(String.valueOf((Float.valueOf(score_before4.getText().toString()) - (Float.valueOf(score44.getText().toString())))));
                            if (confirmed1.getText() == score41.getText()) {
                                score41.setTextColor(getResources().getColor(R.color.green));
                                return;
                            } else {
                                if ((Float.valueOf(confirmed1.getText().toString())) < (Float.valueOf(score41.getText().toString()))) {
                                    score41.setTextColor(getResources().getColor(R.color.red));
                                    score41.setText("-" + score41.getText());
                                } else {
                                    score41.setTextColor(getResources().getColor(R.color.green));
                                    score41.setText(String.valueOf(Float.valueOf(score41.getText().toString()) + Float.valueOf(String.valueOf((Float.valueOf(confirmed1.getText().toString())) - (Float.valueOf(score41.getText().toString())))) / 10.0));
                                }
                            }
                            if ((Float.valueOf(confirmed2.getText().toString())) == (Float.valueOf(score42.getText().toString()))) {
                                score42.setTextColor(getResources().getColor(R.color.green));
                                return;
                            } else {
                                if ((Float.valueOf(confirmed2.getText().toString())) < (Float.valueOf(score42.getText().toString()))) {
                                    score42.setTextColor(getResources().getColor(R.color.red));
                                    score42.setText("-" + score42.getText());
                                } else {
                                    score42.setTextColor(getResources().getColor(R.color.green));
                                    score42.setText(String.valueOf(Float.valueOf(score42.getText().toString()) + Float.valueOf(String.valueOf((Float.valueOf(confirmed2.getText().toString())) - (Float.valueOf(score42.getText().toString())))) / 10.0));
                                }
                            }
                            if ((Float.valueOf(confirmed3.getText().toString())) == (Float.valueOf(score43.getText().toString()))) {
                                score43.setTextColor(getResources().getColor(R.color.green));
                                return;
                            } else {
                                if ((Float.valueOf(confirmed3.getText().toString())) < (Float.valueOf(score43.getText().toString()))) {
                                    score43.setText("-" + score43.getText());
                                    score43.setTextColor(getResources().getColor(R.color.red));
                                } else {
                                    score43.setTextColor(getResources().getColor(R.color.green));
                                    score43.setText(String.valueOf(Float.valueOf(score43.getText().toString()) + Float.valueOf(String.valueOf((Float.valueOf(confirmed3.getText().toString())) - (Float.valueOf(score43.getText().toString())))) / 10.0));
                                }
                            }
                            if ((Float.valueOf(confirmed4.getText().toString())) == (Float.valueOf(score44.getText().toString()))) {
                                score44.setTextColor(getResources().getColor(R.color.green));
                                return;
                            } else {
                                if ((Float.valueOf(confirmed4.getText().toString())) < (Float.valueOf(score44.getText().toString()))) {
                                    score44.setTextColor(getResources().getColor(R.color.red));
                                    score44.setText("-" + score44.getText());
                                } else {
                                    score44.setTextColor(getResources().getColor(R.color.green));
                                    score44.setText(String.valueOf(Float.valueOf(score44.getText().toString()) + Float.valueOf(String.valueOf((Float.valueOf(confirmed4.getText().toString())) - (Float.valueOf(score44.getText().toString())))) / 10.0));

                                }
                            }
                            full_1final1.setText(String.valueOf((Float.valueOf(score_before1.getText().toString()) + (Float.valueOf(score41.getText().toString())))));
                            full_1final2.setText(String.valueOf((Float.valueOf(score_before2.getText().toString()) +- (Float.valueOf(score42.getText().toString())))));
                            full_1final3.setText(String.valueOf((Float.valueOf(score_before3.getText().toString()) + (Float.valueOf(score43.getText().toString())))));
                            full_1final4.setText(String.valueOf((Float.valueOf(score_before4.getText().toString()) + (Float.valueOf(score44.getText().toString())))));
                            FancyButton last_button = (FancyButton) getActivity().findViewById(R.id.confirm_final);
                            last_button.setVisibility(View.VISIBLE);

                            break;
                    }
                }

            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        return builder.create();
    }
}

package com.example.aliakseisemchankau.tehnotrackdz1;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by aliakseisemchankau on 19.3.16.
 */
public class ListViewBaseAdapterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout);
        ListView lv = (ListView) findViewById(R.id.listview);
        String[] names = {"kek", "lol"};
        lv.setAdapter(new MyAdapter(this, names));

    }



    static class MyAdapter extends BaseAdapter {

        Context context;
        ArrayList names;

        public static class ViewHolder {
            public TextView textView;
        }

        MyAdapter(Context context, String[] list) {
            this.context = context;
            names = new ArrayList<>();
            Collections.addAll(names, list);

        }

        public String littleIntToString(int num, int gender) {

            String res = "";

            if (num == 0) {
                return "";
            }

            if (num >= 900 && num < 1000) {
                res += "девятьсот ";
            }
            if (num >= 800 && num < 900) {
                res += "восемьсот ";
            }
            if (num >= 700 && num < 800) {
                res += "семьсот ";
            }
            if (num >= 600 && num < 700) {
                res += "шестьсот ";
            }
            if (num >= 500 && num < 600) {
                res += "пятьсот ";
            }
            if (num >= 400 && num < 500) {
                res += "четыреста ";
            }
            if (num >= 300 && num < 400) {
                res += "триста ";
            }
            if (num >= 200 && num < 300) {
                res += "двести ";
            }
            if (num >= 100 && num < 200) {
                res += "сто ";
            }

            num = num%100;

            if (num >= 90 && num < 100) {
                res += "девяносто ";
            }
            if (num >= 80 && num < 90) {
                res += "восемьдесят ";
            }
            if (num >= 70 && num < 80) {
                res += "семьдесят ";
            }
            if (num >= 60 && num < 70) {
                res += "шестьдесят ";
            }
            if (num >= 50 && num < 60) {
                res += "пятьдесят ";
            }
            if (num >= 40 && num < 50) {
                res += "сорок ";
            }
            if (num >= 30 && num < 40) {
                res += "тридцать ";
            }
            if (num >= 20 && num < 30) {
                res += "двадцать ";
            }
            if (num >= 10 && num < 20) {
                if (num == 10) {
                    res += "десять ";
                    return res;
                }
                if (num == 11) {
                    res += "одиннадцать ";
                    return res;
                }
                if (num == 12) {
                    res += "двенадцать ";
                    return res;
                }
                if (num == 13) {
                    res += "тринадцать";
                    return res;
                }
                if (num == 14) {
                    res += "четырнадцать ";
                    return res;
                }
                if (num == 15) {
                    res += "пятнадцать ";
                    return res;
                }
                if (num == 16) {
                    res += "шестнадцать ";
                    return res;
                }
                if (num == 17) {
                    res += "семнадцать ";
                    return res;
                }
                if (num == 18) {
                    res += "восемнадцать ";
                    return res;
                }
                if (num == 19) {
                    res += "девятнадцать ";
                    return res;
                }
            }


            num = num%10;

            if (num == 9) {
                res += "девять ";
            }
            if (num == 8) {
                res += "восемь ";
            }
            if (num == 7) {
                res += "семь ";
            }
            if (num == 6) {
                res += "шесть ";
            }
            if (num == 5) {
                res += "пять ";
            }
            if (num == 4) {
                res += "четыре ";
            }
            if (num == 3) {
                res += "три ";
            }
            if (num == 2) {
                if (gender == 0) {
                    res += "два ";
                } else {
                    res += "две ";
                }
            }
            if (num == 1) {
                if (gender == 0) {
                    res += "один ";
                } else {
                    res += "одна ";
                }
            }

            return res;

        }

        public String thouending(int end) {
            if (end == 0) {
                return "тысяч ";
            }
            if (end == 1) {
                return "тысяча ";
            }
            if (end < 5) {
                return "тысячи ";
            }
            return "тысяч ";
        }

        public String millending(int end) {
            if (end == 0) {
                return "миллионов ";
            }
            if (end == 1) {
                return "миллион ";
            }
            if (end < 5) {
                return "миллиона ";
            }
            return "миллионов ";
        }

        public String intToString(int position) {

            int units = position % 1000;
            position /= 1000;

            String res1 = littleIntToString(units, 0);

            int thousands = position % 1000;
            position /= 1000;

            String res2 = littleIntToString(thousands, 1);
            if (thousands > 0) {
                res2 += thouending(thousands % 10);
            }

            int millions = position % 1000;

            String res3 = littleIntToString(millions, 0);
            if (millions > 0) {
                res3 += millending(millions % 10);
            }

            return res3 + res2 + res1;


        }

        @Override
        public int getCount() {
            return 1000000;
        }


        @Override
        public Object getItem(int position) {
            return intToString(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            String str = (String) getItem(position + 1);
            Log.w(String.valueOf(position + 1), "position");
            Log.w(str, "mean");
            ViewHolder holder;
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
                holder = new ViewHolder();
                holder.textView = (TextView)convertView.findViewById(R.id.element_text);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder)convertView.getTag();
            }
            holder.textView.setText(str);
            if ((position & 1) == 1) {
                convertView.setBackgroundColor(Color.rgb(170, 170, 170));
            } else {
                convertView.setBackgroundColor(Color.rgb(255, 255, 255));
            }
            return convertView;
        }
    }
}

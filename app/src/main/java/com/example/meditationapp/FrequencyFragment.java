package com.example.meditationapp;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;


public class FrequencyFragment extends Fragment {


    public FrequencyFragment() {
        // Required empty public constructor
    }

    ArrayList<listview> headerdescription;
    ListView listView;
    listAdapter listAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frequency, container, false);

        headerdescription = new ArrayList<>();
       new Thread(new Runnable() {
           @Override
           public void run() {
               Log.i(TAG, "Thread Running: "+Thread.currentThread().getId());

               headerdescription.add(new listview("MINI RELAXATION MEDITATION","Take a relaxing break from whatever you're doing to sink into the bliss of your own being.", "528HZ",R.raw.mini_relaxation_guided_mixdown));
               headerdescription.add(new listview("PRESENT MOMENT MEDITATION","8 minutes Daily Calm mindfulness meditation to powerfully restore and re-connect with the present.", "428HZ",R.raw.awareness_overthinking_guided_mixdown));
               headerdescription.add(new listview("OM CHANTING","OM is the Primordial Sound of the Universe. Its the sound that reverberates in the entire cosmos and in every cell of our body.", "828HZ",R.raw.om_chanting_mixdown));
               headerdescription.add(new listview("GRATITUDE AFFIRMATIONS","The power of gratitude attracts love, abundance, success, good health, and all that you dream to achieve.  ", "788HZ",R.raw.grateful_affirmations_mixdown));
               headerdescription.add(new listview("POWERFUL AFFIRMATIONS","Affirmations for Self-confidence, Inner strength and Disciplined Mind ", "328HZ",R.raw.alphamale_affirmations));
               headerdescription.add(new listview("BEGINNER GUIDED MEDITATION","This 5 minute guided mindfulness meditation will allow you to slow down and become aware of the present moment.  Clear your head, and become relaxed into the NOW.", "228HZ",R.raw.guided_meditation_girl));
               headerdescription.add(new listview("SHORT BREAK"," 10 minute guided meditation for relaxation you can do on your work break when you're in need of stress relief or calmness.", "128HZ",R.raw.mini_break_work_mixdown));
               headerdescription.add(new listview("SOOTHING SEA WAVES","Calm your mind with soothing sound of sea waves.", "128HZ",R.raw.waves_sound_mixdown));

           }
       }).start();
         listAdapter = new listAdapter(getContext(), headerdescription);

        listView = view.findViewById(R.id.listMode);

        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {




                switch (position)
                {
                    case 1:
                    case 6:
                    case 5:
                    case 4:
                    case 3: {
                        listview abc = headerdescription.get(position);
                        MusicPlayerFragment musicPlayerFragment = new MusicPlayerFragment();
                        Bundle bundle = new Bundle();
                        bundle.putInt("backgroundColor", Color.parseColor("#FF8A00"));
                        bundle.putInt("lightShadow", Color.parseColor("#FFA63D"));
                        bundle.putInt("darkShadow", Color.parseColor("#33000000"));
                        bundle.putInt("visualizer", Color.parseColor("#FF8A00"));
                        bundle.putInt("music",abc.getAudioresrc());
                        bundle.putBoolean("check",true);
                        musicPlayerFragment.setArguments(bundle);

                        FragmentTransaction fragmentTransaction = getActivity()
                                .getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fadein,R.anim.fadeout,R.anim.fadein,R.anim.fadeout).addToBackStack(null);
                        fragmentTransaction.replace(R.id.frame, musicPlayerFragment);
                        fragmentTransaction.commit();
                        break;

                    }
                    case 2:
                    case 9:
                    case 7: {
                        listview abc = headerdescription.get(position);
                        MusicPlayerFragment musicPlayerFragment = new MusicPlayerFragment();
                        Bundle bundle = new Bundle();
                        bundle.putInt("backgroundColor", Color.parseColor("#FF8A00"));
                        bundle.putInt("lightShadow", Color.parseColor("#FFA63D"));
                        bundle.putInt("darkShadow", Color.parseColor("#33000000"));
                        bundle.putInt("visualizer", Color.parseColor("#FF8A00"));
                        bundle.putInt("music",abc.getAudioresrc());
                        bundle.putBoolean("check",false);
                        musicPlayerFragment.setArguments(bundle);

                        FragmentTransaction fragmentTransaction = getActivity()
                                .getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fadein,R.anim.fadeout,R.anim.fadein,R.anim.fadeout).addToBackStack(null);
                        fragmentTransaction.replace(R.id.frame, musicPlayerFragment);
                        fragmentTransaction.commit();
                        break;

                    }
                    default:
                    {



                            MusicPlayerFragment musicPlayerFragment = new MusicPlayerFragment();
                            Bundle bundle = new Bundle();
                            bundle.putInt("backgroundColor", Color.parseColor("#FF8A00"));
                            bundle.putInt("lightShadow", Color.parseColor("#FFA63D"));
                            bundle.putInt("darkShadow", Color.parseColor("#33000000"));
                            bundle.putInt("visualizer", Color.parseColor("#FF8A00"));
                            bundle.putInt("music",R.raw.guided_meditation_girl);
                            bundle.putBoolean("check",true);
                            musicPlayerFragment.setArguments(bundle);

                            FragmentTransaction fragmentTransaction = getActivity()
                                    .getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fadein,R.anim.fadeout,R.anim.fadein,R.anim.fadeout).addToBackStack(null);
                            fragmentTransaction.replace(R.id.frame, musicPlayerFragment);
                            fragmentTransaction.commit();

                        break;

                    }










                }
            }
        });


        return view;
    }


}
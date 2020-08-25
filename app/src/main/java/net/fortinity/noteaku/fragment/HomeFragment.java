package net.fortinity.noteaku.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.fortinity.noteaku.R;
import net.fortinity.noteaku.SettingsActivity;
import net.fortinity.noteaku.adapter.NotesAdapter;
import net.fortinity.noteaku.model.NotesModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements NotesAdapter.OnRecyclerItemClick {

    private RecyclerView recyclerView;
    private NotesAdapter notesAdapter;
    private List<NotesModel> modelList;
    private ImageView settingNote;

    private String[] head = {"Video call to client team.",
            "Video call to team lead.",
            "Python practise.",
            "Coding my app",
            "Python practise.",
            "Coding my app"};

    private String[] desc = {"This is some random data for showing the description in the layout.",
            "This is some random data for showing the description in the layout.",
            "This is some random data for showing the description in the layout.",
            "This is some random data for showing the description in the layout.",
            "This is some random data for showing the description in the layout.",
            "This is some random data for showing the description in the layout."};

    private String[] time = {"11:15 am", "12:30 am", "2:30 pm", "4:00 pm", "2:30 pm", "4:00 pm"};

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recycler);
        settingNote = view.findViewById(R.id.setting_note);

        modelList = new ArrayList<>();
        for (int i = 0; i < head.length; i++) {
            NotesModel notesModel = new NotesModel();
            notesModel.setHead(head[i]);
            notesModel.setDesc(desc[i]);
            notesModel.setTime(time[i]);
            //if you want to use icons for different categories you can use the following line :
            //notesModel.setView(PASS ICONS HERE LIKE WORK, PERSONAL, ETC);
            modelList.add(notesModel);
        }
        notesAdapter = new NotesAdapter(modelList, getContext());
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(notesAdapter);

        notesAdapter.setOnRecyclerItemClick(this);

        settingNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), SettingsActivity.class));
            }
        });

        return view;
    }

    @Override
    public void onClick(int pos) {
        Toast.makeText(getContext(), "Pos is : " + pos, Toast.LENGTH_SHORT).show();
    }
}

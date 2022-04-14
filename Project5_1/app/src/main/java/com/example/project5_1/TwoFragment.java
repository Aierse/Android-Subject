package com.example.project5_1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TwoFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
<<<<<<< HEAD
        View view= inflater.inflate(R.layout.page2, container, false);
        return view;
    }
}
=======
        View view = inflater.inflate(R.layout.page2, container, false);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
>>>>>>> 47d84819fadb929b2fc751b0d16e95583fe6c162

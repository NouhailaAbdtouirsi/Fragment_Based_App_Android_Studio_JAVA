package com.abdtouirsi.atelier4r;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class FragmentA extends Fragment {

    private Spinner spinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        // Fill the spinner with the spinner_value xml file
        spinner = view.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                requireContext(),
                R.array.spinner_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Initialize views
        Button buttonToast = view.findViewById(R.id.button_toast);
        Button buttonNavigate = view.findViewById(R.id.button_navigate);

        // Set up the Toast button click listener
        buttonToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the selected item from the spinner
                String selectedItem = spinner.getSelectedItem().toString();
                // Show a Toast message with the selected item
                Toast.makeText(getActivity(), "Selected: " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });

        // Set up the navigation button click listener
        buttonNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the NavController
                NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
                // Navigate to FragmentB
                navController.popBackStack();
                navController.navigate(R.id.action_fragment_a_to_fragment_b);
            }
        });

        return view;
    }
}

package whoyouquote.yero007.com.whoyouquote.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import whoyouquote.yero007.com.whoyouquote.R;
import whoyouquote.yero007.com.whoyouquote.adapters.AvatarsAdapter;
import whoyouquote.yero007.com.whoyouquote.data.Avatar;

/**
 * Created by Dani on 16.06.2015.
 * This will be the class that will be used to register the user in the online database.
 */


// Snackbar.make
// (container, "You must write a name,
// if you don't have one, please choose one for yourself!", Snackbar.LENGTH_SHORT).show()

public class RegisterFragment extends Fragment {

    private static final int NUMBER_OF_AVATAR_COLUMNS = 2;
    private OnRegisterFragmentInteraction mListener;
    private EditText nameEditText;
    public static RegisterFragment newInstance() {
        return new RegisterFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_register, container, false);

        nameEditText = (EditText) rootView.findViewById(R.id.et_register_name);
        Button registerButton = (Button) rootView.findViewById(R.id.btn_register_register);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                mListener.onRegisterButtonPressed(name,0);
            }
        });

        ArrayList<Avatar> avatars = new ArrayList<>();
        avatars.add(new Avatar(R.drawable.panda));
        avatars.add(new Avatar(R.drawable.monkey));
        avatars.add(new Avatar(R.drawable.parrot));
        avatars.add(new Avatar(R.drawable.elephant));
        avatars.add(new Avatar(R.drawable.panda));
        avatars.add(new Avatar(R.drawable.monkey));
        avatars.add(new Avatar(R.drawable.parrot));
        avatars.add(new Avatar(R.drawable.elephant));
        avatars.add(new Avatar(R.drawable.panda));
        avatars.add(new Avatar(R.drawable.monkey));
        avatars.add(new Avatar(R.drawable.parrot));
        avatars.add(new Avatar(R.drawable.elephant));
        avatars.add(new Avatar(R.drawable.panda));
        avatars.add(new Avatar(R.drawable.monkey));
        avatars.add(new Avatar(R.drawable.parrot));
        avatars.add(new Avatar(R.drawable.elephant));

        RecyclerView avatarRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv_register_avatars);
        avatarRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), NUMBER_OF_AVATAR_COLUMNS));
        avatarRecyclerView.setAdapter(new AvatarsAdapter(avatars, new AvatarsAdapter.OnAvatarClickedListener() {
            @Override
            public void onAvatarClicked(int position, int avatarResourceId) {
                Toast.makeText(getActivity(), "position: "+position+" resourceId:"+avatarResourceId, Toast.LENGTH_SHORT).show();
            }
        }));

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnRegisterFragmentInteraction) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnRegisterFragmentInteraction");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnRegisterFragmentInteraction {
        void onRegisterButtonPressed(String name, int avatarId);
    }
}

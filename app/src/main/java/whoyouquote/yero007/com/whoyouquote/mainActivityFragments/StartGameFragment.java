package whoyouquote.yero007.com.whoyouquote.mainActivityFragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;

import whoyouquote.yero007.com.whoyouquote.R;
import whoyouquote.yero007.com.whoyouquote.activities.ScrollTestActivity;
import whoyouquote.yero007.com.whoyouquote.adapters.AvatarsAdapter;
import whoyouquote.yero007.com.whoyouquote.data.Avatar;

/**
 * Activities that contain this fragment must implement the
 * {@link OnStartGameFragmentInteraction} interface
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class StartGameFragment extends Fragment {

    private OnStartGameFragmentInteraction mListener;

    public StartGameFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_start_game, container, false);

        View startGame = rootView.findViewById(R.id.tv_home_start_game);
        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onGameStartedPressed();
            }
        });

        RecyclerView avatarRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv_home_start_categories);
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
        avatarRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        avatarRecyclerView.setAdapter(new AvatarsAdapter(avatars, new AvatarsAdapter.OnAvatarClickedListener() {
            @Override
            public void onAvatarClicked(int position, int avatarResourceId) {
                Toast.makeText(getActivity(), "position: "+position+" resourceId:"+avatarResourceId, Toast.LENGTH_SHORT).show();

                Intent scrollTestIntent = new Intent(getActivity(), ScrollTestActivity.class);
                getActivity().startActivity(scrollTestIntent);
            }
        }));

        final ScrollView containerScroll = (ScrollView) rootView.findViewById(R.id.sv_home_start_scroll);

        rootView.post(new Runnable() {
            @Override
            public void run() {
                containerScroll.scrollTo(0,0);
            }
        });
        return rootView;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnStartGameFragmentInteraction) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnStartGameFragmentInteraction");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnStartGameFragmentInteraction {
        // TODO: Update argument type and name
        void onGameStartedPressed();
    }

}

package org.d3if0122.kalkulatorbmi


import android.content.ActivityNotFoundException
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.fragment_main.*
import org.d3if0122.kalkulatorbmi.databinding.FragmentMainBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 *
 */
class MainFragment : Fragment() {
    private var berat = 0.0
    private var tinggi = 0.0
    private var hitung = 0.0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentMainBinding>(
            inflater,
            R.layout.fragment_main,
            container,
            false
        )

        btn_bagikan.setOnClickListener {
            var shareIntent = ShareCompat.IntentBuilder.from(requireActivity())
//                .setText(getString(R.string))
                .setType("text/plain")
                .intent
            try {
                startActivity(shareIntent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(context, "Kosong !", Toast.LENGTH_SHORT).show()
            }
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }


    private fun onShare() {

    }
}

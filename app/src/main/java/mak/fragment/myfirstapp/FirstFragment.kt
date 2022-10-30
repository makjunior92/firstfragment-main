package mak.fragment.myfirstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import mak.fragment.myfirstapp.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private fun countMe(view:View) {
        val showCountTextView = view.findViewById<TextView>(R.id.textview_first)
        val countString = showCountTextView.text.toString()
        var count = Integer.parseInt(countString)
        count++

        showCountTextView.text = count.toString()

    }
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button2).setOnClickListener() {
            //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)

            val showCountTextView =view.findViewById<TextView>(R.id.textview_first)
            val currentCount = showCountTextView.text.toString().toInt()
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount)
            findNavController().navigate(action)
        }

        view.findViewById<Button>(R.id.button1).setOnClickListener(){
            val myToast = Toast.makeText(context, "Hello Toast!", Toast.LENGTH_SHORT)
            myToast.show()
        }

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            countMe(view)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
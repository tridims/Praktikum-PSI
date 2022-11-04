package com.dimastri.psirecyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.dimastri.psirecyclerview.R

class FragmentMain () : Fragment(R.layout.fragment_main) {
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view = inflater.inflate(R.layout.fragment_main, container, false);
    val joinBtn = view.findViewById<Button>(R.id.join_button)

    joinBtn.setOnLongClickListener {
      Toast.makeText(activity, "Your longest wish will come true", Toast.LENGTH_SHORT).show()
      true
    }

    joinBtn.setOnClickListener {
      when (joinBtn.text) {
        getString(R.string.join_class_button) -> {
          joinBtn.setText(R.string.joined_class_button)
          Toast.makeText(activity, "Successfully joined", Toast.LENGTH_SHORT).show()
        }
        getString(R.string.joined_class_button) -> {
          joinBtn.setText(R.string.join_class_button)
          Toast.makeText(activity, "Canceled", Toast.LENGTH_SHORT).show()
        }
      }
    }

    joinBtn.setOnHoverListener { _, _ ->
      Toast.makeText(activity, "You hover", Toast.LENGTH_SHORT).show()
      true
    }

    val viewAllBtn1 = view.findViewById<Button>(R.id.ViewAllButton1)
    val viewAllBtn2 = view.findViewById<Button>(R.id.ViewAllButton2)

    for (btn in arrayOf(viewAllBtn1, viewAllBtn2)) {
      btn.setOnClickListener{
        Toast.makeText(activity, "Viewing All", Toast.LENGTH_SHORT).show()
      }
    }

    return view
  }

}
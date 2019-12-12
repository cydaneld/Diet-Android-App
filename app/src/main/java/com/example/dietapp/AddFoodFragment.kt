package com.example.dietapp


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController


class AddFoodFragment : Fragment()
{
    private var mFoodViewModel: FoodViewModel? = null
    lateinit var fragview:View
    private var mEditWordView: EditText? = null

    lateinit var button: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true)
         fragview = inflater.inflate(R.layout.fragment_add_food,container,false)
         mEditWordView = fragview.findViewById(R.id.edit_food)
         button = fragview.findViewById(R.id.button_save)
        mFoodViewModel = ViewModelProviders.of(this).get(FoodViewModel::class.java)
        button.setOnClickListener {addFoods(it)}

        return fragview
    }

    private fun addFoods(view: View)
    {
        val foodInput = mEditWordView!!.text.toString()
        val food = Food(foodInput)
        mFoodViewModel!!.insert(food)
        val imm =
            activity!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (null != activity!!.currentFocus) imm.hideSoftInputFromWindow(
            activity!!.currentFocus!!
                .applicationWindowToken, 0
        )
        view.findNavController().navigate(R.id.action_addFoodFragment2_to_calorieFragment)



    }


}

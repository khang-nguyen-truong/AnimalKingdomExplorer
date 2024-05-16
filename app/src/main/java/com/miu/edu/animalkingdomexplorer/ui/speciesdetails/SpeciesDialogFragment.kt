package com.miu.edu.animalkingdomexplorer.ui.speciesdetails

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialogFragment
import com.google.android.material.textfield.TextInputEditText
import com.miu.edu.animalkingdomexplorer.R
import com.miu.edu.animalkingdomexplorer.data.model.Species
import com.miu.edu.animalkingdomexplorer.databinding.SpeciesDialogBinding
import com.mobsandgeeks.saripaar.ValidationError
import com.mobsandgeeks.saripaar.Validator
import com.mobsandgeeks.saripaar.annotation.NotEmpty

class SpeciesDialogFragment(private val itemClicked: OnAddSpeciesItemClicked) :
    AppCompatDialogFragment(), Validator.ValidationListener {

    private lateinit var binding: SpeciesDialogBinding
    private lateinit var validator: Validator

    @NotEmpty(message = "Name Field is required")
    lateinit var nameEditText: TextInputEditText


    @NotEmpty(message = "Description Field is required")
    lateinit var descriptionEditText: TextInputEditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SpeciesDialogBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.DialogFragment)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*
        * Initializing fields
        * */
        initializingFields()

        validator = Validator(this)
        validator.setValidationListener(this)

        binding.saveTextView.setOnClickListener {
            validator.validate()
        }

        binding.cancelTextView.setOnClickListener {
            dismiss()
        }
    }

    private fun initializingFields() {
        nameEditText = binding.nameEditText
        descriptionEditText = binding.speciesEditText
    }

    override fun onValidationSucceeded() {
        val name = nameEditText.text.toString()
        val description = descriptionEditText.text.toString()
        itemClicked.onSpeciesItemClick(
            Species(
                name, description
            ), dialog
        )
    }

    override fun onValidationFailed(errors: MutableList<ValidationError>?) {
        val message = errors?.get(0)?.getCollatedErrorMessage(this.context)
        Toast.makeText(this.context, message, Toast.LENGTH_LONG).show()
    }
}

interface OnAddSpeciesItemClicked {
    fun onSpeciesItemClick(species: Species, dialog: Dialog?)
}
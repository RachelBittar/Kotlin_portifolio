package bittar.rachel.shoesstores.details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import bittar.rachel.shoesstores.R
import bittar.rachel.shoesstores.databinding.DetailsFragmentBinding

class DetailsFragment : Fragment() {

    private lateinit var viewModel: DetailsViewModel
    private lateinit var viewModelFactory: DetailsViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return inflater.inflate(R.layout.details_fragment, container, false)

        val binding: DetailsFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.details_fragment,
            container,
            false
        )


        val detailsFragmentArgs by navArgs<DetailsFragmentArgs>()

        viewModelFactory = DetailsViewModelFactory(detailsFragmentArgs.image,detailsFragmentArgs.shoes, detailsFragmentArgs.prices)
        viewModel = ViewModelProvider(this,viewModelFactory).get(DetailsViewModel::class.java)


        viewModel.finalImage.observe(viewLifecycleOwner, Observer { newfinalImage ->
                binding.imageView2.setImageResource(newfinalImage)

        })


        binding.detailsViewModel = viewModel

        viewModel.eventPlayAgain.observe(viewLifecycleOwner, Observer { playAgain ->
            if (playAgain) {
                findNavController().navigate(DetailsFragmentDirections.actionRestart())
                viewModel.onPlayAgainComplete()
            }
        })



        return binding.root
    }

}


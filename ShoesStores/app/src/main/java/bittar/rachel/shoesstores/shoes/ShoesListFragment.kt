package bittar.rachel.shoesstores.shoes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment.findNavController
import bittar.rachel.shoesstores.R
import bittar.rachel.shoesstores.databinding.FragmentShoesListBinding



class ShoesListFragment : Fragment() {

    private lateinit var viewModel: ShoesListViewModel
    private lateinit var binding: FragmentShoesListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoes_list,
            container,
            false
        )

        viewModel = ViewModelProvider(this).get(ShoesListViewModel::class.java)
        binding.shoesViewModel = viewModel

        binding.setLifecycleOwner(this)

        viewModel.details.observe(viewLifecycleOwner, Observer { newWord ->
            binding.textName.text = newWord
        })


//        viewModel.image.observe(viewLifecycleOwner, Observer { newWord ->
//            binding.imageView3.setImageLevel(newWord)
//        })





        viewModel.eventGiveDetails.observe(viewLifecycleOwner, Observer { isDetailed ->
            if (isDetailed) {
                var currentShoes = viewModel.details.value
                var currentPrice = viewModel.price.value ?: 0
                var currentImage= viewModel.image.value ?: 0

                val action = ShoesListFragmentDirections.
                actionShoesListFragmentToDetailsFragment(
                    currentShoes.toString(),
                    currentPrice,
                    currentImage
                )

                findNavController(this).navigate(action)
                viewModel.onGameFinishComplete()
            }
        })


        return binding.root

    }

}
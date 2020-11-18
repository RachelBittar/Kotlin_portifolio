package bittar.rachel.shoesstores.shoes

import android.os.Bundle
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

        viewModel.shoe.observe(viewLifecycleOwner, Observer { newshoe ->
            binding.wordText.text = newshoe
        })

//        viewModel.price.observe(viewLifecycleOwner, Observer { newprice ->
//            binding.priceText.text = newprice.toString()
//        })

        viewModel.eventGiveDetails.observe(viewLifecycleOwner, Observer { isDetailed ->
            if (isDetailed) {
                var currentShoes = viewModel.shoe.value
                var currentPrice = viewModel.price.value ?: 0
                val action = ShoesListFragmentDirections.
                actionShoesListFragmentToDetailsFragment(
                    currentShoes.toString(),
                    currentPrice
                )

                findNavController(this).navigate(action)
                viewModel.onGameFinishComplete()
            }
        })


        return binding.root

    }

}
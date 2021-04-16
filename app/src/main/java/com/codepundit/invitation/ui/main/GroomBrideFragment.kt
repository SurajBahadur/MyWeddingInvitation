package com.codepundit.invitation.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.codepundit.invitation.R
import com.codepundit.invitation.databinding.FragmentGroomBrideBinding
import com.codepundit.invitation.utis.loadCard
import com.codepundit.invitation.utis.loadImageRound


class GroomBrideFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentGroomBrideBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_groom_bride, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateUI()
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.btnCard1.setOnClickListener(this)
        binding.btnCard2.setOnClickListener(this)
        binding.btnUpdated.setOnClickListener(this)
        binding.floatingActionButton.setOnClickListener(this)
    }

    private fun updateUI() {
        when (arguments?.getInt(PlaceholderFragment.ARG_SECTION_NUMBER)) {
            1 -> {
                //GROOM
                binding.tvName.text = getString(R.string.groom_name)
                binding.tvDenoteParent.text = "S/O"
                binding.tvParentName.text = getString(R.string.groom_parent)
                binding.ivProfile.loadImageRound(R.drawable.ic_groom)
                binding.layer.visibility = View.GONE
                binding.floatingActionButton.visibility = View.GONE
            }
            2 -> {
                //BRIDE
                binding.tvName.text = getString(R.string.bride_name)
                binding.tvDenoteParent.text = "D/O"
                binding.tvParentName.text = getString(R.string.bride_parent)
                binding.ivProfile.loadImageRound(R.drawable.ic_bride)
                binding.layer.visibility = View.GONE
                binding.floatingActionButton.visibility = View.GONE
            }
            3 -> {
                //INVITATION
                binding.layer.visibility = View.VISIBLE
                binding.tvName.visibility = View.GONE
                binding.ivProfile.visibility = View.GONE
                binding.floatingActionButton.visibility = View.VISIBLE
                binding.ivInvitation.loadCard(R.drawable.ic_invitation_card)
                binding.ivInvitation.rotation=180f
            }
        }
    }

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int): GroomBrideFragment {
            return GroomBrideFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnCard1 -> {
                binding.ivInvitation.loadCard(R.drawable.ic_invitation_card)
                binding.ivInvitation.rotation=180f
            }
            R.id.btnCard2 -> {
                binding.ivInvitation.loadCard(R.drawable.ic_card_greet)
                binding.ivInvitation.rotation=0f

            }
            R.id.btnUpdated -> {
                binding.ivInvitation.loadCard(R.drawable.bg_wedding_morning)
                binding.ivInvitation.rotation=0f
            }
            R.id.floatingActionButton->{
                if(binding.layer.visibility==View.VISIBLE){
//                    binding.layer.animate().alpha(0f).duration = 3000
                    binding.layer.visibility=View.GONE
                }else{
//                    binding.layer.animate().alpha(1f).duration = 3000
                    binding.layer.visibility=View.VISIBLE
                }
            }
        }
    }
}
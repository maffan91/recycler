package com.app.affan.recyclerview.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.affan.recyclerview.R;
import com.app.affan.recyclerview.model.Contact;

import org.zakariya.stickyheaders.SectioningAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by maffan on 12/30/2016.
 */

public class StickyContactsAdapter extends SectioningAdapter {




    Locale locale = Locale.getDefault();

    private class Section {
        String alpha;
        ArrayList<Contact> contacts  = new ArrayList<>();
    }

    public class ItemViewHolder extends SectioningAdapter.ItemViewHolder {

        TextView name;
        TextView email;
        TextView number;

        public ItemViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            email = (TextView) itemView.findViewById(R.id.email);
            number = (TextView) itemView.findViewById(R.id.number);
        }

    }

    public class HeaderViewHolder extends SectioningAdapter.HeaderViewHolder{

        TextView sectionTitle;
        public HeaderViewHolder(View itemView) {
            super(itemView);
            sectionTitle = (TextView) itemView.findViewById(R.id.section_title);
        }
    }

    //
    private List<Contact> contactList = new ArrayList<>();
    ArrayList<Section> sections = new ArrayList<>();


    public StickyContactsAdapter(){

    }


    @Override
    public int getNumberOfSections() {

        return sections.size();
    }

    @Override
    public int getNumberOfItemsInSection(int sectionIndex) {

        return sections.get(sectionIndex).contacts.size();
    }

    @Override
    public boolean doesSectionHaveHeader(int sectionIndex) {
        return true;
    }

    @Override
    public boolean doesSectionHaveFooter(int sectionIndex) {
        return false;
    }

    @Override
    public ItemViewHolder onCreateItemViewHolder(ViewGroup parent, int itemType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.contact_item, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public HeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent, int headerType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.contact_item_header, parent, false);
        return new HeaderViewHolder(v);
    }



    @Override
    public void onBindItemViewHolder(SectioningAdapter.ItemViewHolder viewHolder, int sectionIndex, int itemIndex, int itemUserType) {

        Section s = sections.get(sectionIndex);
        ItemViewHolder ivh = (ItemViewHolder) viewHolder;
        Contact contact = s.contacts.get(itemIndex);

        ivh.name.setText(capitalize(contact.getName()));
        ivh.email.setText(contact.getEmail());
        ivh.number.setText(contact.getNumber());

    }

    @Override
    public void onBindHeaderViewHolder(SectioningAdapter.HeaderViewHolder viewHolder, int sectionIndex, int headerUserType) {

        Section s = sections.get(sectionIndex);
        HeaderViewHolder hvh = (HeaderViewHolder) viewHolder;
        hvh.sectionTitle.setText(s.alpha);

    }

    private String capitalize(String s) {
        if (s != null && s.length() > 0) {
            return s.substring(0,1).toUpperCase(locale) + s.substring(1);
        }

        return "";
    }

    public void setContactList(){

        contactList.add(new Contact("Alex","alex@gmail.com","323 111 333"));
        contactList.add(new Contact("Allen","allen@gmail.com","123 111 333"));
        contactList.add(new Contact("Alice","alice@gmail.com","786 111 333"));
        contactList.add(new Contact("Alex","alex@gmail.com","323 111 333"));

        contactList.add(new Contact("Bob","bob@gmail.com","323 111 333"));
        contactList.add(new Contact("Brian","allen@gmail.com","123 111 333"));
        contactList.add(new Contact("Bsdfe","alice@gmail.com","786 111 333"));
        contactList.add(new Contact("Bsdfwe","alex@gmail.com","323 111 333"));

        contactList.add(new Contact("Casdf","alex@gmail.com","323 111 333"));
        contactList.add(new Contact("Cerew","allen@gmail.com","123 111 333"));
        contactList.add(new Contact("Ckiui","alice@gmail.com","786 111 333"));
        contactList.add(new Contact("Cffdf","alex@gmail.com","323 111 333"));

        contactList.add(new Contact("Dqewq","alex@gmail.com","323 111 333"));
        contactList.add(new Contact("Dasdf","allen@gmail.com","123 111 333"));
        contactList.add(new Contact("Drewq","alice@gmail.com","786 111 333"));
        contactList.add(new Contact("Dncnc","alex@gmail.com","323 111 333"));

        contactList.add(new Contact("Efasdf","alex@gmail.com","323 111 333"));
        contactList.add(new Contact("Etre","allen@gmail.com","123 111 333"));
        contactList.add(new Contact("Envnv","alice@gmail.com","786 111 333"));
        contactList.add(new Contact("Endnd","alex@gmail.com","323 111 333"));

        contactList.add(new Contact("Fasdf","alex@gmail.com","323 111 333"));
        contactList.add(new Contact("Fwerw","allen@gmail.com","123 111 333"));
        contactList.add(new Contact("Fwqre","alice@gmail.com","786 111 333"));
        contactList.add(new Contact("Fzxc","alex@gmail.com","323 111 333"));

        contactList.add(new Contact("Gsdf","alex@gmail.com","323 111 333"));
        contactList.add(new Contact("Good","allen@gmail.com","123 111 333"));
        contactList.add(new Contact("Gasd","alice@gmail.com","786 111 333"));
        contactList.add(new Contact("Gavbvb","alex@gmail.com","323 111 333"));


        // sort people into buckets by the first letter of last name
        sections.clear();
        char alpha = 0;
        Section currentSection = null;
        for (Contact contact : contactList) {
            if (contact.getName().charAt(0) != alpha) {
                if (currentSection != null) {
                    sections.add(currentSection);
                }

                currentSection = new Section();
                alpha = contact.getName().charAt(0);
                currentSection.alpha = String.valueOf(alpha);
            }

            if (currentSection != null) {
                currentSection.contacts.add(contact);
            }
        }
        sections.add(currentSection);


    }






}

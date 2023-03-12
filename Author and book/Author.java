public class Author {
    /**
     *   Kritim Bastola is the author
     * Creating an Author class
     */

    // instances

    private int birthYear ;
    private int yearOfDeath ;

    private String surName;

    private String givenName;

    public Author(String surName, String givenName) {
        this.surName = surName;
        this.givenName = givenName;
        this.birthYear = AuthorBookConstants.UNSPECIFIED_YEAR;
        this.yearOfDeath = AuthorBookConstants.UNSPECIFIED_YEAR;



    }

    /**
     *
     * @return birth year of author
     */
    public int getBirthYear(){


        return birthYear;

    }

    /**
     *
     * @return death year of author
     */
    public int getDeathYear(){

        return yearOfDeath;
    }

    /**
     *
     * @param birth
     * birth year of author
     */
    public void setLifespan(int birth){
        if(birth>-2000 && birth<2025 && birth!=0){
            this.birthYear = birth;
        }
    }

    /**
     *
     * @param birth
     * birth year of author
     * @param death
     * death year of author
     */
    public void setLifespan(int birth, int death){

            if (birth>-2000 && birth<2025 && birth<death && birth!=0 && death!=0){
                this.birthYear = birth;
                this.yearOfDeath = death;
            }
        }

    /**
     *
     * @param other
     * other author
     * @return true if author are the same
     */

    public boolean hasSameName(Author other){
        String firstName = givenName;
        char firstLetter = firstName.charAt(0);
        char surNameLetter = surName.charAt(0);
        char otherFirstLetter = other.givenName.charAt(0);
        char otherLastName = other.surName.charAt(0);

        if(firstName.equals(other.givenName) && surName.equals(other.surName)){
            return true;
        }
        else if(firstLetter == otherFirstLetter && surNameLetter==otherLastName){
            return firstName.length() == 1 || other.givenName.length() == 1;
        }
        else{
            return false;
        }

    }

    /**
     *
     * @return surname , givenname as string
     */
    public String toString(){


        return surName+", "+givenName;
    }

    /**
     *
     * @return properly formatted author info according to the info we have
     */
    public String getLongString(){
        if (birthYear==AuthorBookConstants.UNSPECIFIED_YEAR && yearOfDeath == AuthorBookConstants.UNSPECIFIED_YEAR){
            return toString();

        }
        else if (yearOfDeath==AuthorBookConstants.UNSPECIFIED_YEAR){
            return toString() + " (born "+ birthYear +")";
        }
        else{
            return toString() + " ("+ birthYear +"-"+yearOfDeath+")";
        }


    }

}

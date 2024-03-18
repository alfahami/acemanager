import java.util.Arrays;

public class Acemanager {
    private Member[] members;
    private Formation[] formations;
    private StayCard[] stayCards;
    private FacultyInstitute[] facultyInstitutes;
    private City[] cities;


    public Acemanager(City[] cities, Formation[] formations, FacultyInstitute[] facs, Member[] members, StayCard[] cards){
        this.members = new Member[members.length];
        for (int i = 0; i < this.members.length; i++) {
            this.members[i] = members[i];
            this.members[i].setIdMember(i+1);
        }     
        
        this.stayCards = new StayCard[cards.length];
        for (int i = 0; i < this.stayCards.length; i++) {
            this.stayCards[i] = cards[i];
            this.stayCards[i].setIdCard(i+1);
        }   
        
        this.cities = new City[cities.length];
        for (int i = 0; i < this.cities.length; i++) {
            this.cities[i] = cities[i];
            this.cities[i].setIdCity(i+1);
        }  
        
        this.formations = new Formation[formations.length];
        for (int i = 0; i < this.formations.length; i++) {
            this.formations[i] = formations[i];
            this.formations[i].setIdFormation(i+1);
        }  

        this.facultyInstitutes = new FacultyInstitute[facs.length];
        for (int i = 0; i < this.facultyInstitutes.length; i++) {
            this.facultyInstitutes[i] = facs[i];
            this.facultyInstitutes[i].setIdFacultyInstitute(i+1);
        }  
    }

    public Acemanager(Member[] members) {
        this.members = new Member[members.length];
        for (int i = 0; i < this.members.length; i++) {
            this.members[i] = members[i];
            this.members[i].setIdMember(i+1);
        }        
    }

    public Acemanager(City[] cities){
        this.cities = new City[cities.length];
        for (int i = 0; i < cities.length; i++) {
            this.cities[i] = cities[i];
            this.cities[i].setIdCity(i+1);
        }
    }

    public Member getMember(int index) {
        return this.members[index];
    }

    public void setmember(Member Member, int index) {
       Member copy = new Member(Member);
       this.members[index] = copy;
    }

    public Formation getFormation(int i) {
        return this.formations[i];
    }

    public void setFormation(int i, Formation formation) {
        Formation copy = new Formation(formation);
        this.formations[i] = copy;
    }

    public StayCard getStayCard(int i) {
        return this.stayCards[i];
    }

    public void setStayCard(int i, StayCard stayCard) {
        StayCard copy = new StayCard(stayCard);
        this.stayCards[i] = copy;
    }

    public City getCity(int i){
        return this.cities[i];
    }

    public FacultyInstitute getFacultyInstitute(int i) {
        return this.facultyInstitutes[i];
    }

    public void setFacultyInstitutes(FacultyInstitute[] facultyInstitutes) {
        this.facultyInstitutes = facultyInstitutes;
    }


    public Member[] getMembers() {
        return this.members;
    }

    public void setMembers(Member[] members) {
        this.members = members;
    }

    public Formation[] getFormations() {
        return this.formations;
    }

    public void setFormations(Formation[] formations) {
        this.formations = formations;
    }

    public StayCard[] getStayCards() {
        return this.stayCards;
    }

    public void setStayCards(StayCard[] stayCards) {
        this.stayCards = stayCards;
    }

    public FacultyInstitute[] getFacultyInstitutes() {
        return this.facultyInstitutes;
    }

    public City[] getCities() {
        return this.cities;
    }

    public void setCities(City[] cities) {
        this.cities = cities;
    }

    public StayCard getCard(int i){
        return this.stayCards[i];
    }

    
    public void printAnyArrays(Object[] arrays){
        if(arrays != null){
            String className = arrays.getClass().getCanonicalName();           
                // switch array instance
                //String className = arrays[i].getClass().getName();
                switch(className){
                    case "Member[]":
                        System.out.println(printTableTitle("LIST OF ACEM MEMBERS"));
                        System.out.print("\n  ID | \t   FULL NAME  \t  | AGE | PASSPORT  | MAT AMCI |  CIN     |   PATTERN   |    CITY    |      FORMATION       |   DIPLOMA   | FACULTY | ADHESION |       EMAIL       |\n ----|--------------------|-----|-----------|----------|----------|-------------|------------|----------------------|-------------|---------|----------|-------------------|\n");
                        for (int i = 0; i < arrays.length; i++) {

                            Member member = getMember(i);
            
                    /*#### HACK TO HAVE AN AWESOME DISPLAY OF THE ARRAY IN THE CONSOLE */
            
                            // we used ternary for displayind id in the same column no matter how many digits it holds
                            String fullName = member.getFirstName() + " " + member.getLastName();
            
                            // THINK ABOUT USING STRINGBUILDER as it offers a set length, the idea would be to print all the Stringbuilder object and when no value found print space
                            
                    /*### HACK ENDS  */
                        System.out.println( printId(i, member.getIdMember())+ " | " + formatString(fullName, 17) + "| " + member.getAge() + "  | " + member.getPassport() + " | "  + member.getMatriculeAmci() + " | " + getCardById(member.getIdStayCard()).getCardNum() + " | " + formatString(getCardById(member.getIdStayCard()).getPattern(), 10) + "| " + formatString(getCityName(member.getIdCity()), 9)  + "| " + formatString(getFormationMember(member.getIdFormation()).getName(), 19) + "| " + formatString(getFormationMember(member.getIdFormation()).getFCertificate(), 10) + "| " + formatString(getMemberFaculty(member.getIdFacultyInstitute()).getNameFacInst(), 6) + "| " + (member.isMember() == true ? (formatString("YES ", 6)) : (formatString("NO ", 6))) + " | " + formatString(getMember(i).getEmail(), 16) + "|");
                        System.out.print(i < arrays.length - 1 ? " ----|--------------------|-----|-----------|----------|----------|-------------|------------|----------------------|-------------|---------|----------|-------------------|\n" : "\n\n");
                        }
                        break;
                    case "City[]":
                    System.out.println(printTableTitle("LIST OF CITIES"));
                        System.out.println("");
                        System.out.print("\n\t\t\t\t     ID | \t  CITY     |\tREGION\t\t          |   \t\tFACULTIES\t\t |\n\t\t\t\t    ----|------------------|------------------------------|--------------------------------------|\n");
                        for (int i = 0; i < arrays.length; i++) {
                            City city = this.getCity(i);
                            System.out.println("\t\t\t\t   " + printId(i, city.getIdCity()) + " | " + formatString(city.getName(), 14) + " | " + formatString(city.getRegion(), 26) + " | "  + Arrays.toString(city.getFacs()) + "  |");
                            System.out.print((i < arrays.length - 1) ? "\t\t\t\t    ----|------------------|------------------------------|--------------------------------------|\n" : "\n\n");
                        }
                        break;
                    case "Formation[]":
                        System.out.println(printTableTitle("LIST OF FORMATIONS"));
                        System.out.print("\n\t\t\t\t\t\t  ID |    FORMATION NAME    | CERTIFICATE    |  DURATION \t  |\n\t\t\t\t\t\t ----|----------------------|----------------|--------------------|\n");
                        for (int i = 0; i < arrays.length; i++) {
                            Formation formation = getFormation(i);
                            System.out.println("\t\t\t\t\t\t" + printId(i, formation.getIdFormation()) + " | " + formatString(formation.getName(), 18) + " | " + formatString(formation.getFCertificate(), 12) + " | " + formation.getDuration() + "\t\t  |");
                            System.out.print((i < arrays.length - 1) ? "\t\t\t\t\t\t ----|----------------------|----------------|--------------------|\n" : "\n\n");
                        }
                        break;
                    case "FacultyInstitute[]":
                        System.out.println(printTableTitle("LIST OF FACULTIES"));
                        System.out.print("\n\t\t     ID |    FACULTY    | FORMATIONS\t\t\t\t\t\t\t\t\t\t\t\t\t  |\n\t\t    ----|---------------|-----------------------------------------------------------------------------------------------------------------|\n");
                        for (int i = 0; i < arrays.length; i++) {
                            FacultyInstitute fac = getFacultyInstitute(i);
                            System.out.println("\t\t   " + printId(i, fac.getIdFacultyInstitute()) + " | " + formatString(fac.getNameFacInst(), 11) + " | " + Arrays.toString(fac.getFormationNames()) + " |" );
                            //System.out.println("\t ----|---------------|------------------------------------------------------------------------------------------------------------------");
                            System.out.print((i < arrays.length - 1) ? "\t\t    ----|---------------|-----------------------------------------------------------------------------------------------------------------|\n" : "\n\n");
                        }
                        break;
                    case "StayCard[]":
                        System.out.println(printTableTitle("LIST OF STAY CARDS"));
                        System.out.print("\n\t\t\t     ID | FULL NAME\t\t  | BIRTH DATE |   CIN    |  STAY REASON | OBTENTION DATE | EXPIRATION DATE |  PIN   |\n\t\t\t    ----|-------------------------|------------|----------|--------------|----------------|-----------------|--------|\n");
                        for (int i = 0; i < arrays.length; i++) {
                            StayCard card = getCard(i);
                            System.out.println("\t\t\t   " + printId(i, card.getIdCard()) + " | " + formatString(getMemberCard(card.getIdMember()).getFirstName() + " " + getMemberCard(card.getIdMember()).getLastName(), 21) + " | " + getMemberCard(card.getIdMember()).getBirthDate() + " | " + card.getCardNum() + " | "+ formatString(card.getPattern(), 10) + " | " + formatString(card.getObtentionDate(), 12) + " | " + formatString(card.getExpirationDate(), 13) + " | " + card.getPin() + " |");
                            System.out.print((i < arrays.length - 1) ? "\t\t\t    ----|-------------------------|------------|----------|--------------|----------------|-----------------|--------|\n" : "\n\n");
                        }
                        break;
                        default:
                            System.out.println("The fuck you trying to do though");
                }
            
            //System.out.print("\n");
        } else System.exit(0);
    }

    public StayCard getCardById(int idStayCard){
            for (int j = 0; j < this.stayCards.length; j++) {
                if(idStayCard == getStayCard(j).getIdCard()){
                    return getStayCard(j);
                } 
            }
            return null;   
    }

    public String getCityName(int idCity){
        String cityName = "";
            for (int j = 0; j < this.cities.length; j++) {
                if(idCity == getCity(j).getIdCity()){
                    cityName = getCity(j).getName();
                } 
            }
        return cityName; 
    }

    public Formation getFormationMember(int idFormation){
            for (int j = 0; j < this.formations.length; j++) {
                if(idFormation == getFormation(j).getIdFormation()){
                   return getFormation(j);
                } 
            }
            return null; 
    }

    public FacultyInstitute getMemberFaculty(int idFacultyInstitute){
            for (int j = 0; j < this.facultyInstitutes.length; j++) {
                if(idFacultyInstitute == getFacultyInstitute(j).getIdFacultyInstitute()){
                    return facultyInstitutes[j];
                } 
            }
            return null; 
    }

    public String getCertificateName(int idFormation){
        String certifName = "";
            for (int j = 0; j < this.formations.length; j++) {
                if(idFormation == getFormation(j).getIdFormation()){
                    certifName = getFormation(j).getFCertificate();
                } 
            }
            return certifName; 
    }

    public Member getMemberCard(int idMember){
        Member member = new Member();
        for (int i = 0; i < this.members.length; i++) {
            if(idMember == getMember(i).getIdMember()){
                member = getMember(i);
                return member;
            }
        }
        return null;
    }

    public String formatString(String s, int i){
        String space = " ";
        if(s.length() < i){
            for (int j = 0; j <= i- s.length(); j++) {
                space += " "; 
            }
        }
        return s + space;
    }

    public String printId(int i, int id){
        return ( i < 9 ?  ("  " + String.valueOf(id)) + " " : (" " + String.valueOf(id)) + " ");
    }

    public String printTableTitle(String tTitle){
        return "\n\t\t\t\t\t\t\t\t\t==========================\n\t\t\t\t\t\t\t\t\t\s\s\s" + tTitle + "\n\t\t\t\t\t\t\t\t\t==========================\n";
    }

 
}

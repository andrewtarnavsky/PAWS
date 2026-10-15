import PetCard from "./PetCard.jsx";

function PetList({pets}){
    return(
        <div className={petListType(pets)}>
            {pets.map((pet) => (
                <PetCard
                    key = {pet.id}
                    pet = {pet}
                />
            ))}
        </div>
    )
}
export default PetList;

function petListType(pets){
    if(pets.length === 1){
        return "pet-list pet-list-single";
    } else if(pets.length === 2){
        return "pet-list pet-list-double";
    } else{
        return "pet-list";
    }
}
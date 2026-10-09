import PetCard from "./PetCard.jsx";

function PetList({pets}){
    return(
        <div className="pet-list-container">
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
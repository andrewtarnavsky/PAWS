import {useState} from "react";

function PetCard({pet}){


    return(
        <div className="pet-card-container">
            <img
                className="pet-card-img"
                src = {getSpeciesImage(pet.species)}
                alt= "Pet Icon"
            />
            <h3 style={{margin: '5px auto', fontSize: '30px'}}>{pet.name}</h3>
            <p style={{fontSize: '16px'}}>{pet.breed}</p>
            <p className="pet-card-details">
                {`Age: ${pet.age}   •   Weight: ${pet.weight} lbs`}
            </p>
            <button className="pet-card-button">
                View Profile
            </button>
        </div>
    )
}
export default PetCard;

function getSpeciesImage(species){
    species = species.toLowerCase();

    if(species.includes("dog")){
        return "/images/species/dog.jpg";
    }

    if (species.includes("cat")) {
        return "/images/species/cat.jpg";
    }

    if (species.includes("bird")) {
        return "/images/species/bird.png";
    }

    if (species.includes("rabbit")) {
        return "/images/species/rabbit.jpg";
    }
}
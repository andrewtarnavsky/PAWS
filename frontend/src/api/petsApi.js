const BASE_URL = "http://localhost:8080/api/pets";

export async function getPets() {
    const response = await fetch(BASE_URL);

    if (!response.ok) {
        throw new Error("Failed to fetch pets");
    }

    return response.json();
}

export async function createPet(pet) {
    const response = await fetch(BASE_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(pet),
    });

    if (!response.ok) {
        throw new Error("Failed to create pet");
    }

    return response.json();
}
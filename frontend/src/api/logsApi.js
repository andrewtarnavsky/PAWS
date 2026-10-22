const BASE_URL = "http://localhost:8080/api";

export async function getLogs(petId) {
    const response = await fetch(`${BASE_URL}/pets/${petId}/logs`);

    if (!response.ok) {
        throw new Error(`Failed to fetch logs for pet ${petId}: ${response.statusText}`);
    }

    return await response.json();
}

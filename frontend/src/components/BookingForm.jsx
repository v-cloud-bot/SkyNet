import { useState } from 'react';
import axios from 'axios';

export default function BookingForm() {
  const [formData, setFormData] = useState({
    materialType: '',
    pickupLocation: '',
    dropLocation: '',
    userId: 1 // Matches the ID we inserted in Step 1
  });

  const handleSubmit = async (e) => {
    e.preventDefault();
    const payload = {
      materialType: formData.materialType,
      pickupLocation: formData.pickupLocation,
      dropLocation: formData.dropLocation,
      user: { id: formData.userId } // Nesting the ID for JPA
    };

    try {
      const response = await axios.post("http://localhost:8080/api/book", payload);
      alert("Data added successfully! Booking ID: " + response.data.id);
    } catch (error) {
      console.error("Fail:", error);
      alert("Check Console for Error");
    }
  };

  return (
    <form onSubmit={handleSubmit} style={{ display: 'flex', flexDirection: 'column', gap: '10px', width: '300px' }}>
      <input type="text" placeholder="Material Type" onChange={(e) => setFormData({...formData, materialType: e.target.value})} />
      <input type="text" placeholder="Pickup (From)" onChange={(e) => setFormData({...formData, pickupLocation: e.target.value})} />
      <input type="text" placeholder="Drop (To)" onChange={(e) => setFormData({...formData, dropLocation: e.target.value})} />
      <button type="submit">Add Booking</button>
    </form>
  );
}
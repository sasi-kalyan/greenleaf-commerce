import { useState } from "react";

function Login() {

    const [user, setUser] = useState({
        username: "",
        password: "",
        role: ""
    });

    const rootusername = "green_leaf_admin";
    const rootpassword = "green_leaf_admin@123";

    const credentials = btoa(`${rootusername}:${rootpassword}`);

    const handleChange = (e) => {
        setUser(
            {
                ...user,
                [e.target.name]: e.target.value
            }
        )
    }

    const handleSubmit = async (e) => {
        e.preventDefault();
        try{
            const response = await fetch('http://localhost:8080/api/admin/create', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': `Basic ${credentials}`
                },
                body: JSON.stringify(user)
            });

            alert('USER created successfully with ROLE ' + user.role);
            console.log('USER created successfully with ROLE ' + user.role, response);
        } catch (error) {
            console.error('Error creating user:', error);
        }
    };


    return (

        <section className="m-5 flex-1 flex flex-col justify-center items-center">

            <form className="w-md flex flex-col gap-4 p-5 border-1 border-black text-md rounded-xl" onSubmit={handleSubmit}>
                <label htmlFor="username">Username</label>
                <input type="text" id="username" name="username" className="w-full p-2 border-1 border-black" value={user.username} onChange={handleChange} />
                <label htmlFor="password">Password</label>
                <input type="password" id="password" name="password" className="w-full p-2 border-1 border-black" value={user.password} onChange={handleChange} />
                <label htmlFor="role">Role</label>
                <input type="text" id="role" name="role" className="w-full p-2 border-1 border-black" value={user.role} onChange={handleChange} />
                <button type="submit" className="px-5 py-2 border-1 border-black bg-black text-white">Login</button>
            </form>
        </section>
        
    )
}

export default Login;
import { useState } from "react";
import { useNavigate } from "react-router-dom";

function Login() {

    const navigate = useNavigate();

    const [user, setUser] = useState({
        username: "",
        password: "",
        role: ""
    });

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

            const credentials = btoa(`${user.username}:${user.password}`);

            const response = await fetch('http://localhost:8080/api/admin/', {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': `Basic ${credentials}`
                }
                // body: JSON.stringify(user)
            });

            if(response.status === 200) {
                alert('Logged in as ' + user.username);
                console.log('Logged in as ' + user.username, response);
                navigate("/admin");

            } else {
                alert('Failed to log in (user not found)');
                console.log('Failed to log in', response);
            }

        } catch (error) {
            console.error('Error creating user:', error);
        }
    };


    return (

        <section className="m-5 flex-1 flex flex-col justify-center items-center">

            <form className="w-sm flex flex-col gap-3 p-5 border-1 border-black text-md rounded-xl" onSubmit={handleSubmit}>
                <label htmlFor="username">Username</label>
                <input type="text" id="username" name="username" className="w-full p-2 border-1 border-black text-sm rounded-xl" value={user.username} onChange={handleChange} />
                <label htmlFor="password">Password</label>
                <input type="password" id="password" name="password" className="w-full p-2 border-1 border-black text-sm rounded-xl" value={user.password} onChange={handleChange} />
                {/* <label htmlFor="role">Role</label>
                <input type="text" id="role" name="role" className="w-full p-2 border-1 border-black text-sm" value={user.role} onChange={handleChange} /> */}
                
                <label htmlFor="role">Role</label>
                <select name="role" id="role" className="w-full p-2 border-1 border-black text-sm rounded-xl" value={user.role} onChange={handleChange}>
                    <option value="ADMIN">ADMIN</option>
                    <option value="USER">USER</option>
                </select>
                <button type="submit" className="w-fit px-8 self-center bg-gl-nav p-1 text-white cursor-pointer transition duration-150 ease-in-out hover:bg-sky-700">Login</button>

                <div className="flex justify-center gap-5 text-sm">
                    <a href="#" className="underline text-blue-600">Create an account</a>
                    <a href="#" className="underline text-blue-600">Forgot password?</a>
                </div>
            </form>
        </section>
        
    )
}

export default Login;
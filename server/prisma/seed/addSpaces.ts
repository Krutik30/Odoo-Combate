import { faker } from '@faker-js/faker';
import prisma from '../../utils/prismaClient';

async function main() {

    const roles = ['Admin', 'Advertiser', 'SpaceOwner'];

    const users = [];

    for (let i = 0; i < 10; i++) {
        const role = faker.helpers.arrayElement(roles);

        const userData = {
            email: faker.internet.email(),
            name: faker.name.firstName(),
            password: faker.internet.password(),
            role,
            createdAt: new Date(),
            updatedAt: new Date(),
        };

        const newUser = await prisma.user.create({
            data: userData,
        });

        users.push(newUser);
    }

    // Generate adminDetails, advertiserDetails, and spaceOwnerDetails for each user
    for (const user of users) {
        switch (user.role) {
            case 'Admin': {
                await prisma.adminDetails.create({
                    data: {
                        user_id: user.id,
                        fullName: `${faker.name.firstName()} ${faker.name.lastName()}`,
                        contactNumber: faker.datatype.number({ min: 1000000000, max: 9999999999 }),
                        profilePic: faker.image.avatar(),
                    },
                });
                break;
            }
            case 'Advertiser': {
                await prisma.advertiserDetails.create({
                    data: {
                        user_id: user.id,
                        fullName: `${faker.name.firstName()} ${faker.name.lastName()}`,
                        contactNumber: faker.datatype.number({ min: 1000000000, max: 9999999999 }),
                        department: faker.commerce.department(),
                        companyAddress: faker.address.streetAddress(),
                        industry: faker.company.name(),
                        profilePic: faker.image.avatar(),
                        ownerDetailId: faker.datatype.uuid(),
                    },
                });
                break;
            }
            case 'SpaceOwner': {
                await prisma.spaceOwnerDetails.create({
                    data: {
                        user_id: user.id,
                        fullName: `${faker.name.firstName()} ${faker.name.lastName()}`,
                        contactNumber: faker.datatype.number({ min: 1000000000, max: 9999999999 }),
                        companyAddress: faker.address.streetAddress(),
                        profilePic: faker.image.avatar(),
                    },
                });
                break;
            }
            default:
                break;
        }
    }

    console.log('Seed data added successfully.');


}
main()
    .catch((e) => {
        console.error(e);
        process.exit(1);
    })
    .finally(async () => {
        await prisma.$disconnect();
    });

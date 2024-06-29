import { faker } from '@faker-js/faker';
import prisma from '../../utils/prismaClient';

async function main() {
    for (let i = 0; i < 10; i++) {
        const user = await prisma.user.create({
            data: {
                email: faker.internet.email(),
                name: faker.name.fullName(),
                password: faker.internet.password(),
                role: 'Admin',
                adminDetails: {
                    create: {
                        fullName: faker.name.fullName(),
                        contactNumber: faker.datatype.number({ min: 1000000000, max: 9999999999 }),
                        profilePic: faker.image.avatar(),
                    }
                }
            }
        });

        const advertiser: any = await prisma.user.create({
            data: {
                email: faker.internet.email(),
                name: faker.name.fullName(),
                password: faker.internet.password(),
                role: 'Advertiser',
                advertiserDetails: {
                    create: {
                        fullName: faker.name.fullName(),
                        contactNumber: faker.datatype.number({ min: 1000000000, max: 9999999999 }),
                        department: faker.commerce.department(),
                        companyAddress: faker.address.streetAddress(),
                        industry: faker.company.name(),
                        profilePic: faker.image.avatar(),
                        ownerDetailId: faker.datatype.uuid(),
                    }
                }
            }
        });

        const spaceOwner: any = await prisma.user.create({
            data: {
                email: faker.internet.email(),
                name: faker.name.fullName(),
                password: faker.internet.password(),
                role: 'SpaceOwner',
                spaceOwnerDetails: {
                    create: {
                        fullName: faker.name.fullName(),
                        contactNumber: faker.datatype.number({ min: 1000000000, max: 9999999999 }),
                        companyAddress: faker.address.streetAddress(),
                        profilePic: faker.image.avatar(),
                    }
                }
            }
        });

        const space = await prisma.space.create({
            data: {
                name: faker.commerce.productName(),
                description: faker.commerce.productDescription(),
                address: faker.address.streetAddress(),
                location: faker.address.city(),
                ownerId: spaceOwner.spaceOwnerDetails.user_id,
                status: faker.helpers.arrayElement(['available', 'booked']),
                price: faker.datatype.number({ min: 1000, max: 5000 }),
                size: faker.datatype.number({ min: 10, max: 100 }),
                type: faker.helpers.arrayElement(['billboard', 'digital', 'transit']),
                image: faker.image.imageUrl(),
                owner: {
                    connect: {
                        user_id: spaceOwner.spaceOwnerDetails.user_id
                    }
                }
            }
        });

        const advertisement = await prisma.advertise.create({
            data: {
                spaceId: space.id,
                advertiserId: advertiser.advertiserDetails.user_id,
                startDate: faker.date.soon(),
                endDate: faker.date.future(),
            }
        });

        const booking = await prisma.booking.create({
            data: {
                spaceId: space.id,
                adveriserId: advertisement.id,
                price: space.price,
            }
        });

        console.log(`Created user: ${user.id}, advertiser: ${advertiser.id}, spaceOwner: ${spaceOwner.id}, space: ${space.id}, advertisement: ${advertisement.id}, booking: ${booking.id}`);
    }
}

main()
    .catch((e) => {
        console.error(e);
        process.exit(1);
    })
    .finally(async () => {
        await prisma.$disconnect();
    });
